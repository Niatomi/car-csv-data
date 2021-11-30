package ru.niatomi.blank;

import lombok.SneakyThrows;
import ru.niatomi.models.Car;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BlankClass {
    @SneakyThrows
    public static void main(String[] args) {

    List<Integer> a = Stream.of(1,2,3,4).skip(2).collect(Collectors.toList());
        Path path = Paths.get("")
                .toAbsolutePath()
                .resolve("src")
                .resolve("main")
                .resolve("resources")
                .resolve("CAR_DATA.csv");

        Stream<String> lines = Files.lines(path);

        Map<String, Integer> bag = Files.lines(path, StandardCharsets.UTF_8)
                .map(str -> str.replaceAll("[,\\.\\-]", " "))
                .map(str -> str.replaceAll("\\s+", " "))
                .map(String::trim)
                .map(String::toLowerCase)
                .flatMap(line -> Arrays.stream(line.split("\\s+")))
                .collect(Collectors.groupingBy(str -> str))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, ent -> ent.getValue().size()));

        for (Map.Entry<String, Integer> entry : bag.entrySet()) {
            System.out.println(entry);
        }



    }
}
