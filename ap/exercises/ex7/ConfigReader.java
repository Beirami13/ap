package ap.exercises.ex7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ConfigReader {
    public static String readStorageType(String filePath) {
        try {
            for (String line : Files.readAllLines(Paths.get(filePath))) {
                if (line.startsWith("storage=")) {
                    return line.split("=")[1].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "tabsplit"; // default
    }
}

