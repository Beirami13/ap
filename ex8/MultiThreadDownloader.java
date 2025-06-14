package ap.exercises.ex8;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MultiThreadDownloader implements Downloader {
    private String url;
    private String outputPath;
    private int threadCount;

    public MultiThreadDownloader(String url, String outputPath, int threadCount) {
        this.url = url;
        this.outputPath = outputPath;
        this.threadCount = threadCount;
    }

    @Override
    public void download() {
        try {
            URL website = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) website.openConnection();
            int fileSize = connection.getContentLength();
            connection.disconnect();

            int partSize = fileSize / threadCount;

            Thread[] threads = new Thread[threadCount];
            for (int i = 0; i < threadCount; i++) {
                int start = i * partSize;
                int end = (i == threadCount - 1) ? fileSize - 1 : start + partSize - 1;
                threads[i] = new Thread(new DownloadThread(url, outputPath + ".part" + i, start, end));
                threads[i].start();
            }

            for (Thread thread : threads) {
                thread.join();
            }

            mergeParts(outputPath, threadCount);
            System.out.println("Downloaded with " + threadCount + " threads.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mergeParts(String outputPath, int parts) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            for (int i = 0; i < parts; i++) {
                try (FileInputStream fis = new FileInputStream(outputPath + ".part" + i)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
                new File(outputPath + ".part" + i).delete();
            }
        }
    }
}
