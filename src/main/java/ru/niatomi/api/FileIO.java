package ru.niatomi.api;

import lombok.Data;
import ru.niatomi.Application;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class FileIO {

    public void writeFile(Iterable<?> iterable, String filename) throws IOException, URISyntaxException {

        Path path = Paths.get("")
                .toAbsolutePath()
                .resolve("src")
                .resolve("main")
                .resolve("resources")
                .resolve(filename);
        System.out.println(path);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Object elem : iterable) {
                bw.write(elem.toString());
                bw.newLine();
            }
        }
    }

    public Map<String, Integer> readFile() throws URISyntaxException, IOException {

        Path path = Paths.get("")
                    .toAbsolutePath()
                    .resolve("src")
                    .resolve("main")
                    .resolve("resources")
                    .resolve("CAR_DATA.csv");

        Map<String, Integer> bag =
        Files.lines(path, StandardCharsets.UTF_8)
            .map(str -> str.replaceAll("(,)\\1+", ",Not stated,"))
            .map(str -> str.replaceAll("\\s+", " "))
            .map(String::trim)
            .flatMap(line -> Arrays.stream(line.split("\\n+")))
            .collect(Collectors.groupingBy(str -> str))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, ent -> 1, Math::addExact));

        return bag;
    }

}
