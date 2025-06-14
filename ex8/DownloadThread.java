// کلاس کامل DownloadThread.java
package ap.exercises.ex8;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadThread implements Runnable {
    private String url;
    private String outputPath;
    private int start;
    private int end;

    public DownloadThread(String url, String outputPath, int start, int end) {
        this.url = url;
        this.outputPath = outputPath;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestProperty("Range", "bytes=" + start + "-" + end);

            try (InputStream in = connection.getInputStream();
                 RandomAccessFile out = new RandomAccessFile(outputPath, "rw")) {

                out.seek(0); // ensure writing from start of part file
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
