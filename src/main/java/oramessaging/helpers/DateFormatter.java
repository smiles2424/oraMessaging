package oramessaging.helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public final class DateFormatter {
  private static TimeZone tz = TimeZone.getTimeZone("UTC");
  private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
  static {
    df.setTimeZone(tz);
  }

  public static String formatDateToIso(Date date){
    return df.format(date);
  }
}