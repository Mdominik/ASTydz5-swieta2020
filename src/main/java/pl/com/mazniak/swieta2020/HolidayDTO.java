package pl.com.mazniak.swieta2020;

import java.time.LocalDate;

public class HolidayDTO {
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    String date;
    String localName;

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    String dayOfWeek;

    public HolidayDTO(Holiday holiday) {
        this.date = holiday.getDate();
        this.localName = holiday.getLocalName();
        this.dayOfWeek = LocalDate.parse(holiday.getDate()).getDayOfWeek().name().toLowerCase();
    }

}
