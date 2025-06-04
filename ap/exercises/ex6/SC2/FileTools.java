package ap.exercises.ex6.SC2;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.*;
import java.util.List;

public class FileTools {
    public static List<String> getTextFileLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            return null;
        }
    }

    public static void writeTextToFile(String path, String content) {
        try {
            Files.createDirectories(Paths.get(path).getParent());
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeLinesToTextFile(String path, List<String> lines) {
        try (PrintWriter out = new PrintWriter(path)) {
            lines.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

