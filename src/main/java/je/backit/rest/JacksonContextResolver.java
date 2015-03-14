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
package je.backit.rest;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import static com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

/**
 * this is necessary to parse java time objects, in conjunction with the jackson JSR310 module.
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {
  private static final ObjectMapper om = init();

  @Override public ObjectMapper getContext(Class<?> objectType) {
    return om;
  }

  private static ObjectMapper init() {
    ObjectMapper om = new ObjectMapper();
    om.registerModule(new JSR310Module());
    om.registerModule(new JooqModule());
    om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    om.getFactory().configure(JsonGenerator.Feature.AUTO_CLOSE_TARGET, false)
            .configure(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM, false);
    om.configure(WRITE_DATES_AS_TIMESTAMPS, false);
    om.setVisibilityChecker(om.getSerializationConfig().getDefaultVisibilityChecker()
            .withIsGetterVisibility(NONE)
            .withGetterVisibility(NONE)
            .withFieldVisibility(ANY));
    return om;
  }
}
