package pl.com.mazniak.swieta2020;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HolidaysDTOManager {
    public List<HolidayDTO> getHolidayDTOList() {
        return holidayDTOList;
    }

    public void setHolidayDTOList(List<Holiday> holidayList) {
        this.holidayDTOList = new ArrayList<HolidayDTO>();
        holidayList.forEach(holiday -> holidayDTOList.add(new HolidayDTO(holiday)));
    }

    List<HolidayDTO> holidayDTOList;
    String country;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    int currentYear = 2019;
    public HolidaysDTOManager() {
        this.holidayDTOList = new ArrayList<HolidayDTO>();
    }
}
