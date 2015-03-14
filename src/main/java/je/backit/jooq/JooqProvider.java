/*
 * Copyright (C) 2015 - present by Yann Le Tallec.
 * Please see distribution for license.
 */

package je.backit.jooq;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import org.jooq.DSLContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
public class JooqProvider {

  private static final Logger LOG = LoggerFactory.getLogger(JooqProvider.class);


  private @Jooq @Inject Instance<DSLContext> sqlProvider;
  private @JooqTest @Inject Instance<DSLContext> sqlTestProvider;

  public DSLContext sql() {
    return sqlTestProvider.get();
  }
}
