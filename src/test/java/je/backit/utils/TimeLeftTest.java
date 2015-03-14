/*
 * Copyright (C) 2015 - present by Yann Le Tallec.
 * Please see distribution for license.
 */

package je.backit.utils;

import java.time.ZonedDateTime;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 */
public class TimeLeftTest {

  private final ZonedDateTime now = ZonedDateTime.now();


  @DataProvider(name = "timeleft")
  public Object[][] timeleft() {
    return new Object[][] {
            { now.minusDays(5).plusMinutes(1), "5", "days left" },
            { now.minusDays(1).minusMinutes(1), "2", "days left" },
            { now.minusDays(1).plusMinutes(1), "24", "hours left" },
            { now.minusHours(1).minusMinutes(1), "2", "hours left" },
            { now.minusHours(1).plusSeconds(1), "60", "minutes left" },
            { now.minusMinutes(5).minusSeconds(1), "6", "minutes left" },
            { now.minusMinutes(1).plusSeconds(5), "1", "minute left" },
    };
  }

  @Test(dataProvider = "timeleft")
  public void test(ZonedDateTime startDate, String expectAmount, String expectedUnit) {
    TimeLeft left = new TimeLeft(startDate, now);
    assertEquals(left.getTimeLeftAsString(), expectAmount);
    assertEquals(left.getUnitAsString(), expectedUnit);
  }

}