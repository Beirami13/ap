package ap.exercises.ex6.SC3;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class NetworkTools {

    public static String downloadHtml(String urlStr) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new URL(urlStr).openStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            return out.toString("UTF-8");
        }
    }

    public static byte[] downloadBinary(String urlStr) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new URL(urlStr).openStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            return out.toByteArray();
        }
    }

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException ignored) {
        }
    }
}
