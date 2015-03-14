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

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import org.jooq.DSLContext;
import static org.jooq.SQLDialect.POSTGRES;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class JooqProducer {
  private static final Logger LOG = LoggerFactory.getLogger(JooqProducer.class);

  private static final String PROD_NAME = "java:jboss/jdbc/backit";
  private static final String TEST_NAME = "java:jboss/jdbc/backit_test";

  @Resource(lookup = PROD_NAME)
  private javax.sql.DataSource postgres;
  @Resource(lookup = TEST_NAME)
  private javax.sql.DataSource postgresTest;

  public @Produces @Jooq DSLContext getDSLContext() {
    LOG.debug("Creating DSLContext with datasource {}", PROD_NAME);
    return DSL.using(postgres, POSTGRES);
  }
  public @Produces @JooqTest DSLContext getTestDSLContext() {
    LOG.debug("Creating DSLContext with datasource {}", TEST_NAME);
    return DSL.using(postgresTest, POSTGRES);
  }
}
