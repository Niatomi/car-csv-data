package ru.niatomi;

import lombok.SneakyThrows;
//import ru.niatomi.api.FileApi;
import ru.niatomi.api.FileIO;
import ru.niatomi.models.Car;
import ru.niatomi.processor.ParseIndexProcessor;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    @SneakyThrows
    public static void main(String[] args) {
        //init
        FileIO fileIO = new FileIO();
        ParseIndexProcessor processor = new ParseIndexProcessor();
        Path path = Paths.get("")
                .toAbsolutePath()
                .resolve("src")
                .resolve("main")
                .resolve("resources")
                .resolve("CAR_DATA.csv");

        //Saving data from file and clearing data on csv
        List<String> bag = fileIO.readFile();
        String header = bag.get(0);
        bag.remove(0);

        //register class
        processor.registerClass(header, Car.class);

        //Car objects
        List<Car> cars = new ArrayList<Car>();
        for (String el: bag) cars.add(processor.parseObject(el, Car.class));

        //Sorting car by color
        Map<String, List<Car>> colorGroup = cars
                .stream()
                .collect(Collectors.groupingBy(Car::getCarColor));

        //File writing
        fileIO.writeFile(cars, "CAR_DATA_OBJECTS.csv");
        fileIO.writeFile(colorGroup.entrySet(), "CAR_DATA_COLOR_GROUPING.csv");
    }
}
