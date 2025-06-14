package ap.exercises.ex8;

import java.io.BufferedReader;
import java.io.FileReader;

public class ConfigReader {
    public static Config read(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            int threadCount = Integer.parseInt(line.split("=")[1].trim());
            return new Config(threadCount);
        } catch (Exception e) {
            return new Config(0);
        }
    }
}
