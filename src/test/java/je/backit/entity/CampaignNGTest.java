/*
 * Copyright (C) 2015 - present by Yann Le Tallec.
 * Please see distribution for license.
 */

package je.backit.entity;

import java.math.BigDecimal;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 */
public class CampaignNGTest {

  @DataProvider(name = "amounts")
  public Object[][] amounts() {
    return new Object[][] {
            {new BigDecimal("10.00"), "10"},
            {new BigDecimal("150.00"), "150"},
            {new BigDecimal("1500.00"), "1,500"},
            {new BigDecimal("15000.00"), "15,000"},
    };
  }

  @Test(dataProvider = "amounts")
  public void targetFundingAsString(BigDecimal amount, String expected) {
    Campaign c = new Campaign();
    c.setTargetFunding(amount);
    assertEquals(c.getTargetFundingAsString(), expected);
  }

}