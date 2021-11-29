package ru.niatomi.api;

import lombok.Data;
import ru.niatomi.Application;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Data
public class FileApi {

    public void writeFile(Iterable<?> iterable, String filename) throws IOException, URISyntaxException {

        Path path = Paths.get(Application.class
                .getClassLoader()
                .getResource(filename)
                .toURI());

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (Object elem : iterable) {
                bw.write(elem.toString());
                bw.newLine();
            }
        }
    }



}
