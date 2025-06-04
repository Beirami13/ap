package ap.exercises.ex6.SC2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkTools {

    public static String downloadHtml(String urlString) {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(urlString);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setConnectTimeout(5000); // ms
            connection.setReadTimeout(5000);    // ms

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = in.readLine()) != null) {
                content.append(line).append("\n");
            }

            in.close();
            return content.toString();

        } catch (Exception e) {
            System.err.println("❌ خطا در دانلود: " + urlString);
            return null;
        }
    }
}

