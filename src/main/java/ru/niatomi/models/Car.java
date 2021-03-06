package ru.niatomi.models;

import lombok.Data;
import lombok.ToString;
import ru.niatomi.annotation.ParseIndex;

@Data
@ToString
public class Car {

    @ParseIndex(headerIndex = 0)
    private String CarModel;

    @ParseIndex(headerIndex = 2)
    private String CarModelYear;

    @ParseIndex(headerIndex = 3)
    private String CarColor;

    @ParseIndex(headerIndex = 1)
    private String Manufacturer;

}
