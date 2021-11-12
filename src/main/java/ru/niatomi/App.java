package ru.niatomi;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    @SneakyThrows
    public static void main(String[] args) {
        Path path = Paths.get(App.class
                .getClassLoader()
                .getResource("CAR_DATA.csv")
                .toURI());
        BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        String data = br.readLine() + "\r\n";
        while (br.readLine() != null) {
            data += br.readLine()+"\r\n";
        }
    }
}
