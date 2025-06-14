package ap.exercises.ex8;

import java.io.*;
import java.net.URL;

public class SingleThreadDownloader implements Downloader {
    private String url;
    private String outputPath;

    public SingleThreadDownloader(String url, String outputPath) {
        this.url = url;
        this.outputPath = outputPath;
    }

    @Override
    public void download() {
        try (InputStream in = new URL(url).openStream();
             FileOutputStream out = new FileOutputStream(outputPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Downloaded with single thread.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
