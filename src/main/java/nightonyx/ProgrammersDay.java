package nightonyx;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.lang.NonNull;

public class ProgrammersDay extends Responce {

    public ProgrammersDay(final int errorCode, final String date) {
        super (errorCode, date);
    }

    @NonNull
    public int getErrorCode() {
        return errorCode;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    @NonNull
    public static String createDate(@NonNull final int year) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        Calendar calendar;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            calendar = new GregorianCalendar(year, Calendar.SEPTEMBER, 12);
        } else {
            calendar = new GregorianCalendar(year, Calendar.SEPTEMBER, 13);
        }
        return dateFormat.format(calendar.getTime());
    }
}

abstract class Responce {
    @NonNull
    public final int errorCode;
    @NonNull
    public final String date;

    Responce(int err, String resp) {
        errorCode = err;
        date = resp;
    }
}
