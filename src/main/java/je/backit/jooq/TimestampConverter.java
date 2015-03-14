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
package je.backit.jooq;

import java.sql.Timestamp;
import java.time.Instant;
import org.jooq.Converter;

/**
 *
 */
public class TimestampConverter implements Converter<Timestamp, Instant> {
  @Override public Instant from(Timestamp ts) {
    return ts == null ? null : Instant.ofEpochMilli(ts.getTime());
  }
  @Override public Timestamp to(Instant instant) {
    return instant == null ? null : new Timestamp(instant.toEpochMilli());
  }
  @Override public Class<Timestamp> fromType() { return Timestamp.class; }
  @Override public Class<Instant> toType() { return Instant.class; }
}
