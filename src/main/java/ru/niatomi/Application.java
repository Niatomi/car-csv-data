package ru.niatomi;

import lombok.SneakyThrows;
import ru.niatomi.models.Car;
import ru.niatomi.models.CarMaker;
import ru.niatomi.processor.ParseIndexProcessor;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    @SneakyThrows
    public static void main(String[] args) {
//        Path path = Paths.get(App.class
//                .getClassLoader()
//                .getResource("CAR_DATA.csv")
//                .toURI());
//        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
//        String data = br.readLine() + "\r\n";
//        while (br.readLine() != null) {
//            data += br.readLine()+"\r\n";
//        }
//        System.out.println(data);


//        ParseIndexProcessor parseIndexProcessor = new ParseIndexProcessor();
//        Car car = parseIndexProcessor.parseObject("Town Car,Lincoln,2007,Orange", Car.class);
//        System.out.println(car);

//        ParseIndexProcessor parseIndexProcessor = new ParseIndexProcessor();
//        CarMaker carMaker = parseIndexProcessor.parseObject("Town Car,Lincoln,2007,Orange", CarMaker.class);
//        System.out.println(carMaker);

    }
}
