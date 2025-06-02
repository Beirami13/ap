package ap.exercises.ex6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileTools {

    public static List<String> getTextFileLines(String filePath){
        try {
            return Files.lines(Paths.get(filePath))
                    .collect(Collectors.toList());
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
}
