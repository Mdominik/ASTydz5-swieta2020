package pl.com.mazniak.swieta2020;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.DayOfWeek;
import java.time.LocalDate;
@Route
public class Gui extends VerticalLayout {
    HolidaysController holidaysController;
    Grid<HolidayDTO> grid;
    Label daysLabel;
    int currentYear = 2019;

    @Autowired
    public Gui(HolidaysController holidaysController) {
        this.holidaysController = holidaysController;
        NumberField numberField = new NumberField();
        numberField.setValue(Double.valueOf(currentYear));
        numberField.setHasControls(true);
        numberField.setMin(2019);
        numberField.setMax(3000);


        add(numberField);

         int howManyDaysOff = (int) this.holidaysController.holidaysDTOManager.getHolidayDTOList().stream().filter(holidayDTO ->
                !(LocalDate.parse(holidayDTO.getDate()).getDayOfWeek() == DayOfWeek.SATURDAY) &&
                !(LocalDate.parse(holidayDTO.getDate()).getDayOfWeek() == DayOfWeek.SUNDAY)).count();
        daysLabel =  new Label(howManyDaysOff + " dni swiatecznych w srodku tygodnia.");
        grid = new Grid<>(HolidayDTO.class);
        grid.setItems( this.holidaysController.holidaysDTOManager.getHolidayDTOList());


        numberField.addValueChangeListener(inputEvent -> {
            holidaysController.holidaysDTOManager.setCurrentYear(inputEvent.getValue().intValue());
            holidaysController.getDataHolidays(inputEvent.getValue().intValue());
            holidaysController.holidaysDTOManager.getHolidayDTOList();
            grid.setItems( holidaysController.holidaysDTOManager.getHolidayDTOList());
            int howManyDaysOffFromListener = (int) holidaysController.holidaysDTOManager.getHolidayDTOList().stream().filter(holidayDTO ->
                    !(LocalDate.parse(holidayDTO.getDate()).getDayOfWeek() == DayOfWeek.SATURDAY) &&
                            !(LocalDate.parse(holidayDTO.getDate()).getDayOfWeek() == DayOfWeek.SUNDAY)).count();
            daysLabel.setText(howManyDaysOffFromListener + " dodatkowych dni wolnych od pracy.");
            currentYear = inputEvent.getValue().intValue();
        });

        add(daysLabel, grid);
    }
}
