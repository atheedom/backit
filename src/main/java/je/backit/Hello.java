/*
 * Copyright (C) 2015 - present by Yann Le Tallec.
 * Please see distribution for license.
 */

package je.backit;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
//import je.fundme.jooq.Tables;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;

/**
 *
 */
@Stateless
@Path("hello")
public class Hello {

  @GET
  public String hello(@QueryParam("name") String name) {
    return "Hello From Jersey" + (name != null ? " " +  name : "") + "!";
  }

}
