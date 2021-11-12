package ru.niatomi.models;

import lombok.Data;
import lombok.ToString;
import ru.niatomi.annotation.ParseIndex;

@Data
@ToString
public class CarMaker {

    @ParseIndex(headerIndex = 0)
    private String NameOfCarMaker;

}
