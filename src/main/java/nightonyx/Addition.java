package nightonyx;

import org.springframework.lang.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Addition extends Responce {

    public Addition(final int errorCode, final String date) {
        super(errorCode, date);
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
    public static String getCountDay(@NonNull final String date) {
        String day = date.substring(0, 2);
        String month = date.substring(2, 4);
        String year = date.substring(4, 8);
        if (month.charAt(0) == '0') {
            month = String.valueOf(month.charAt(1));
        }
        int count = 0;
        String dateYear = ProgrammersDay.createDate(Integer.parseInt(year));
        if (dateYear.substring(0, 2).equals("13")) {
            count = 256;
        } else count = 257;
        System.out.println(count);
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
        calendar1.set(Integer.parseInt(year), 0, 0);
        long time = calendar.getTimeInMillis() - calendar1.getTimeInMillis();
        long dayResult = (time / (1000L * 60L * 60L * 24L));
        return String.valueOf(count - dayResult);
    }
}
