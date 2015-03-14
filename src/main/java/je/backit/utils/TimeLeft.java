/*
 * Copyright (C) 2015 - present by Yann Le Tallec.
 * Please see distribution for license.
 */
package je.backit.utils;

import java.time.ZonedDateTime;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

/**
 *
 */
public class TimeLeft {
  private final ZonedDateTime endDate;
  private final ZonedDateTime startDate;

  public TimeLeft(ZonedDateTime startDate, ZonedDateTime endDate) {
    this.endDate = endDate;
    this.startDate = startDate;
  }

  public String getTimeLeftAsString() {
    if (endDate.isBefore(startDate)) return "";
    long days = DAYS.between(startDate, endDate);
    if (days >= 1) return Long.toString(days + 1);
    long hours = HOURS.between(startDate, endDate);
    if (hours >= 1) return Long.toString(hours + 1);
    long minutes = MINUTES.between(startDate, endDate);
    return Long.toString(minutes + 1);
  }

  public String getUnitAsString() {
    if (endDate.isBefore(startDate)) return "";
    long days = DAYS.between(startDate, endDate);
    if (days >= 1) return "days left";
    long hours = HOURS.between(startDate, endDate);
    if (hours >= 1) return "hours left";
    long minutes = MINUTES.between(startDate, endDate);
    if (minutes > 0) return "minutes left";
    return "minute left";
  }
}
