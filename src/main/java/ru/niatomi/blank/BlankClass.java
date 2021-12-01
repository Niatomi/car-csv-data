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


//        List<Integer> a = Stream.of(1,2,3,4).skip(2).collect(Collectors.toList());
//
//        Stream<String> lines = Files.lines(path);
//        Path path = Paths.get("")
//                .toAbsolutePath()
//                .resolve("src")
//                .resolve("main")
//                .resolve("resources")
//                .resolve("CAR_DATA.csv");
//        Map<String, Integer> bag = Files.lines(path, StandardCharsets.UTF_8)
//                .map(str -> str.replaceAll("[,\\.\\-]", " "))
//                .map(str -> str.replaceAll("\\s+", " "))
//                .map(String::trim)
//                .map(String::toLowerCase)
//                .flatMap(line -> Arrays.stream(line.split("\\s+")))
//                .collect(Collectors.groupingBy(str -> str))
//                .entrySet()
//                .stream()
//                .collect(Collectors.toMap(Map.Entry::getKey, ent -> ent.getValue().size()));
//
//        for (Map.Entry<String, Integer> entry : bag.entrySet()) {
//            System.out.println(entry);
//        }

        Path path = Paths.get("")
                .toAbsolutePath()
                .resolve("src")
                .resolve("main")
                .resolve("resources")
                .resolve("CAR_DATA.csv");

        List<String> list_example = new ArrayList<String>();
        list_example.add("123");
        list_example.add("456");
        list_example.add("789");

        List<String> bag =
                Files.lines(path, StandardCharsets.UTF_8)
                .map(str -> str.replaceAll("(,)\\1+", ",Not stated,"))
                .map(str -> str.replaceAll("\\s+", " "))
                .map(String::trim)
                .flatMap(line -> Arrays.stream(line.split("\\n+")))
                .collect(Collectors.toList());
        System.out.println(bag.get(0));

        Stream stream = list_example.stream();

//        Map<String, Integer> bag =
//                        list_example
//                        .stream()
////                .filter(i -> i
//                        .map(str -> str.replaceAll("(,)\\1+", ",Not stated,"))
//                        .map(str -> str.replaceAll("\\s+", " "))
//                        .map(String::trim)
//                        .flatMap(line -> Arrays.stream(line.split("\\n+")))
//                        .collect(Collectors.groupingBy(str -> str))
//                        .entrySet()
//                        .stream().collect(Collectors.groupingBy(Map.Entry::getKey,  ))

    }
}
