package ru.niatomi.models;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CarMaker {

    private String MakerCompany;

    private List<Car> cars;

    public CarMaker(String makerCompany, List<Car> cars) {
        MakerCompany = makerCompany;
        this.cars = cars;
    }
}
