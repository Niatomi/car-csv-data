package ru.niatomi;

import lombok.SneakyThrows;
import ru.niatomi.api.FileIO;
import ru.niatomi.models.Car;
import ru.niatomi.models.CarMaker;
import ru.niatomi.processor.ParseIndexProcessor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
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

        //3. Saving data from file and clearing data on csv
        List<String> bag = fileIO.readFile();
        String header = bag.get(0);
        bag.remove(0);

        //4. clearing data
        Files.deleteIfExists(path);
        Files.createFile(path);

        //register class
        processor.registerClass(header, Car.class);

        //5. Car objects
        List<Car> cars = new ArrayList<Car>();
        for (String el: bag) cars.add(processor.parseObject(el, Car.class));
        fileIO.writeFile(cars, "CAR_DATA_OBJECTS.csv");

        //6. Sorting car by color
        Map<String, List<Car>> colorGroup = cars
                .stream()
                .collect(Collectors.groupingBy(Car::getCarColor));
        fileIO.writeFile(colorGroup.entrySet(), "CAR_DATA_COLOR_GROUPING.csv");

        //7. Car to CarMaker
        //7.1
        Map<String, List<Car>> carMakers = cars
                .stream()
                .collect(Collectors.groupingBy(Car::getManufacturer));
        //7.2
        List<CarMaker> carMakerList = new ArrayList<CarMaker>();
        for (Map.Entry<String, List<Car>> el : carMakers.entrySet()) {
            carMakerList.add(new CarMaker(el.getKey(), el.getValue()));
        }
        //7.3
        fileIO.writeFile(carMakerList, "MANUFACTURER_DATA.csv");
        //7.4
        String[] carManufacturers = carMakers.keySet().toArray(new String[0]);
        System.out.println(Arrays.stream(carManufacturers).collect(Collectors.joining(",")));

        //8.1 Sorting of manufacturers
        Map<String, List<Car>> sortManufacturers =
                carMakers
                .entrySet()
                .stream()
                .filter(x -> x.getValue().size() > 2)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        //8.2
        List<String> keys = sortManufacturers
                .keySet()
                .stream()
                .sorted().collect(Collectors.toList());
        //8.3
        fileIO.writeFile(keys, "SORTED_MANUFACTURES.csv");

    }
}
