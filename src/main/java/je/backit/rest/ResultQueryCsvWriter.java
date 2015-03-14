/* 
 * Copyright 2014 Yann Le Tallec.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.assylias.bigblue.server.cdi;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.joining;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.ResultQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
@Provider
@Produces(MediaType.TEXT_PLAIN)
public class ResultQueryCsvWriter implements MessageBodyWriter<ResultQuery<?>> {
  private static final Logger LOG = LoggerFactory.getLogger(ResultQueryCsvWriter.class);

  @Override public boolean isWriteable(Class type, Type type1, Annotation[] antns, MediaType mt) {
    boolean isWriteable = ResultQuery.class.isAssignableFrom(type) && mt.equals(MediaType.TEXT_PLAIN_TYPE);
    LOG.debug("in isWriteable: {}/{}, {}/{} => {}", type, ResultQuery.class.isAssignableFrom(type), mt, mt.equals(MediaType.TEXT_PLAIN_TYPE), isWriteable);
    return isWriteable;
  }

  @Override public long getSize(ResultQuery<?> rq, Class<?> type, Type type1, Annotation[] antns, MediaType mt) {
    return -1;
  }

  @Override public void writeTo(ResultQuery<?> rq, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType,
           MultivaluedMap<String,Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
    LOG.debug("Writing csv response");
    Result<?> result = rq.fetch();
    List<String> lines = new ArrayList<> (result.size() + 1);
    String csvHeader = Arrays.stream(result.fields())
            .map(Field::getName)
            .collect(joining("|"));
    LOG.debug("size = {}, headers: {}", result.size(), csvHeader);
    lines.add(csvHeader);

    result.stream()
            .map(rec -> Arrays.stream(rec.intoArray())
                    .map(String::valueOf)
                    .collect(joining("|")))
            .forEach(lines::add);
    String csv = lines.stream().collect(joining("\n"));
    LOG.debug("csv = {}", csv);

    httpHeaders.add("Cache-Control", "no-cache, no-store, must-revalidate");

    entityStream.write(csv.getBytes(UTF_8));
  }
}