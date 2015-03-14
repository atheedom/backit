/*
 * Copyright (C) 2015 - present by Yann Le Tallec.
 * Please see distribution for license.
 */

package je.backit.rest;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import je.backit.control.CampaignDAO;
import je.backit.control.FundDAO;
import je.backit.entity.Campaign;
import je.backit.jooq.tables.records.RewardRecord;

@Stateless
@Path("test")
public class RestTester {

  @Inject CampaignDAO campaigns;
  @Inject FundDAO fund;

  @GET
  @Path("campaign")
  @Produces(APPLICATION_JSON)
  public List<Campaign> getAll() {
    return campaigns.findAll();
  }

  @GET
  @Path("campaign/{id}")
  @Produces(APPLICATION_JSON)
  public Campaign findById(@PathParam("id") Integer campaignId) {
    return campaigns.findById(campaignId);
  }

  @GET
  @Path("fund/{campaign_id}/{user_id}/{amount}")
  @Produces(APPLICATION_JSON)
  public Response fund(@PathParam("campaign_id") Integer campaignId,
          @PathParam("user_id") Integer userId,
          @PathParam("amount") String amount) {
    fund.fundCampaign(campaignId, userId, new BigDecimal(amount));
    return Response.ok().entity("user " + userId + " brought " + amount + " to campaign " + campaignId).build();
  }

  @GET
  @Path("campaign_insert")
  @Produces(APPLICATION_JSON)
  public Response fund(@QueryParam("title") String title,
          @QueryParam("amount") String amount) {
    Campaign c = new Campaign();
    c.setTitle(title);
    c.setTargetFunding(new BigDecimal(amount));
    ZonedDateTime now = ZonedDateTime.now();
    c.setStartDate(now);
    c.setEndDate(now.plusDays(10));

    campaigns.insert(c);
    return Response.ok().entity("campaigns " + title + " created.").build();
  }

  @GET
  @Path("campaign_add_reward")
  @Produces(APPLICATION_JSON)
  public Response fund(@QueryParam("id") Integer id,
          @QueryParam("title") String title,
          @QueryParam("value") String value,
          @QueryParam("number") Integer number) {
    Campaign c = campaigns.findById(id);
    RewardRecord r = new RewardRecord()
            .setDescription(title)
            .setTitle(title)
            .setTotalNumber(number)
            .setValue(new BigDecimal(value));
    campaigns.addReward(c, r);

    return Response.ok().entity("reward " + title + " added to campaign " + c.getTitle()).build();
  }
}
