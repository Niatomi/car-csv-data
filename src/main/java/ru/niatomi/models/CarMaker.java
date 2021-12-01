package ru.niatomi.models;

import lombok.Data;
import lombok.ToString;
import ru.niatomi.annotation.ParseIndex;

import java.util.List;

@Data
@ToString
public class CarMaker {

    private String MakerCompany;

    private List<Car> cars;

}
