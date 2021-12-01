package ru.niatomi.models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.ToString;
import ru.niatomi.annotation.ParseIndex;

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
