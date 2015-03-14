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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.util.Map;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.ResultQuery;
import static org.jooq.tools.StringUtils.toCamelCaseLC;

/**
 *
 */
public class JooqModule extends SimpleModule {

  public JooqModule() {
    addSerializer(ResultQuery.class, new ResultQuerySerializer ());
    addSerializer(Record.class, new RecordSerializer ());
  }

  private static class RecordSerializer extends StdSerializer<Record> {

    public RecordSerializer() {
      super(Record.class);
    }

    @Override public void serialize(Record r, JsonGenerator jg, SerializerProvider sp) throws IOException {
      jg.writeStartObject();
      for (Field<?> fld : r.fields()) {
        writeField(fld.getName(), r.getValue(fld), jg);
      }
      jg.writeEndObject();
    }
  }

  private static class ResultQuerySerializer extends StdSerializer<ResultQuery> {

    public ResultQuerySerializer() {
      super(ResultQuery.class);
    }

    @SuppressWarnings("unchecked")
    @Override public void serialize(ResultQuery q, JsonGenerator jg, SerializerProvider sp) throws IOException {
      jg.writeStartArray();
      q.fetchInto((Record r) -> {
        try {
          final Object out = r;
          if (out instanceof Map) {
            jg.writeStartObject();
            for (Map.Entry<String, ?> e : ((Map<String, ?>) out).entrySet()) {
              writeField(e.getKey(), e.getValue(), jg);
            }
            jg.writeEndObject();
          } else jg.writeObject(out);
          jg.writeRaw('\n');
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      });
      jg.writeEndArray();
    }
  }

  static void writeField(String name, Object value, JsonGenerator jg) throws IOException {
    if (value == null) return;
    jg.writeFieldName(toCamelCaseLC(name));
    if (name.equals("properties")) jg.writeRawValue((String)value);
    else jg.writeObject(value);
  }
}
