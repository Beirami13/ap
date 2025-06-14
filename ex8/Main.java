package ap.exercises.ex8;

public class Main {
    public static void main(String[] args) {
        Config config = ConfigReader.read("config.txt");
        String url = "https://example.com/file.zip";
        String outputFilePath = "output/file.zip";

        Downloader downloader;
        if (config.getThreadCount() > 0) {
            downloader = new MultiThreadDownloader(url, outputFilePath, config.getThreadCount());
        } else {
            downloader = new SingleThreadDownloader(url, outputFilePath);
        }

        downloader.download();
    }
}

