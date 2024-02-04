package varol.pelin.sena.flight_search_api.utils;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(TimeZone.getTimeZone("America/New_York").toZoneId()).toInstant());
    }
}
