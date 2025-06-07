package ap.exercises.ex6.SC3;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class FileTools {

    public static List<String> getTextFileLines(String filePath){
        try {
            return Files.lines(Paths.get(filePath)).collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }

    public static void writeLinesToTextFile(String path, List<String> lines) {
        try (PrintWriter out = new PrintWriter(path)) {
            lines.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStringToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBytesToFile(String path, byte[] data) {
        try {
            Files.write(Paths.get(path), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
