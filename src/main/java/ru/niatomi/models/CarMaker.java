package ru.niatomi.models;

import lombok.Data;
import lombok.ToString;
import ru.niatomi.annotation.ParseIndex;

@Data
@ToString
public class CarMaker {

    @ParseIndex(headerIndex = 1)
    private String MakerCompany;

    private Car car;

}
