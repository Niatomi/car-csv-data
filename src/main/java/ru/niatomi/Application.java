package ru.niatomi;

import lombok.SneakyThrows;
import ru.niatomi.annotation.ParseIndex;
//import ru.niatomi.api.FileApi;
import ru.niatomi.api.FileApi;
import ru.niatomi.models.Car;
import ru.niatomi.models.CarMaker;
import ru.niatomi.processor.ParseIndexProcessor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    @SneakyThrows
    public static void main(String[] args) {
        //init
        ParseIndexProcessor processor = new ParseIndexProcessor();
        Path path = Paths.get(Application.class
                .getClassLoader()
                .getResource("CAR_DATA.csv")
                .toURI());

        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);

        //register class
        String header = br.readLine();
        processor.registerClass(header, Car.class);

        //Car list
        List<Car> cars = new ArrayList<Car>();
        String line;
        while ((line = br.readLine()) != null) {
            cars.add(processor.parseObject(line, Car.class));
        }
        br.close();


//        File writing
        FileApi fileApi = new FileApi();
        fileApi.writeFile(cars, "CAR_DATA_dump.csv");

        System.out.println();
    }
}
