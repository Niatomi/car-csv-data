package ru.niatomi;

import lombok.SneakyThrows;
//import ru.niatomi.api.FileApi;
import ru.niatomi.api.FileIO;
import ru.niatomi.models.Car;
import ru.niatomi.processor.ParseIndexProcessor;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        Map<String, Integer> map = fileIO.readFile();
        System.out.println(map.toString().indexOf(2));
        String header = br.readLine();
        br.close();
//        System.out.println(map.entrySet());
        //register class
        processor.registerClass(header, Car.class);

        List<Car> cars = new ArrayList<Car>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getValue());;
        }

        //Car list
//        List<Car> cars = new ArrayList<Car>();
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            cars.add(processor.parseObject(entry.getKey(), Car.class));
//        }


        //File writing
        fileIO.writeFile(cars, "CAR_DATA_dump.csv");

    }
}
