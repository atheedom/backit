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

import java.sql.Date;
import java.time.LocalDate;
import org.jooq.Converter;

/**
 *
 */
public class DateConverter implements Converter<Date, LocalDate> {
  @Override public LocalDate from(Date date) { return date == null ? null : date.toLocalDate(); }
  @Override public Date to(LocalDate ld) { return ld == null ? null : Date.valueOf(ld); }
  @Override public Class<Date> fromType() { return Date.class; }
  @Override public Class<LocalDate> toType() { return LocalDate.class; }
}
