package nightonyx;

import jdk.internal.jline.internal.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Year;

@Controller
public class Service {

    @RequestMapping("/")
    @ResponseBody
    public Responce getDay(@RequestParam(defaultValue = "0") @Nullable Integer year, @Nullable @RequestParam(defaultValue = "0") String currentDate) {
        if (year != 0 || !currentDate.equals("0")) {
            if (year != 0) {
                if (year < 1) {
                    return new ProgrammersDay(HttpStatus.BAD_REQUEST.value(), "Incorrect year!");
                } else {
                    return new ProgrammersDay(
                            HttpStatus.OK.value(),
                            ProgrammersDay.createDate(year)
                    );
                }
            } else {
                if (currentDate.length() < 8) {
                    return new Addition(HttpStatus.BAD_REQUEST.value(), "Incorrect date!");
                } else {
                    return new Addition(
                            HttpStatus.OK.value(),
                            Addition.getCountDay(currentDate)
                    );
                }
            }
        }
        return new Addition(
                HttpStatus.BAD_REQUEST.value(),
                "Не правильно введено название параметров");
    }
}

