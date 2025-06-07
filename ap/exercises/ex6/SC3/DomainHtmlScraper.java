package ap.exercises.ex6.SC3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomainHtmlScraper {
    private final String domain;
    private final String saveDirectory;
    private final Set<String> visited = new HashSet<>();

    public DomainHtmlScraper(String domain, String saveDirectory) {
        this.domain = domain;
        this.saveDirectory = saveDirectory;
    }

    public void start() throws IOException {
        processPage(domain);
    }

    private void processPage(String url) throws IOException {
        if (visited.contains(url)) return;
        if (!url.startsWith(domain)) return;
        visited.add(url);

        String html = NetworkTools.downloadHtml(url);
        if (html == null || html.isEmpty()) return;

        String localPath = PathTools.getHtmlSavePath(url, saveDirectory);
        FileTools.writeStringToFile(localPath, html);

        List<String> links = new ArrayList<>(HtmlParser.extractUrls(html));
        List<String> imageLinks = new ArrayList<>(HtmlParser.extractImageUrls(html));
        List<String> audioLinks = new ArrayList<>(HtmlParser.extractAudioUrls(html));

        for (String img : imageLinks) {
            if (!img.startsWith("http")) continue;
            if (!visited.contains(img)) {
                visited.add(img);
                try {
                    byte[] data = NetworkTools.downloadBinary(img);
                    String path = PathTools.getImageSavePath(img, saveDirectory);
                    FileTools.writeBytesToFile(path, data);
                } catch (IOException e) {
                    System.err.println("Error downloading or saving image: " + img);
                }
            }
        }

        for (String audio : audioLinks) {
            if (!audio.startsWith("http")) continue;
            if (!visited.contains(audio)) {
                visited.add(audio);
                try {
                    byte[] data = NetworkTools.downloadBinary(audio);
                    String path = PathTools.getAudioSavePath(audio, saveDirectory);
                    FileTools.writeBytesToFile(path, data);
                } catch (IOException e) {
                    System.err.println("Error downloading or saving audio: " + audio);
                }
            }
        }

        for (String link : links) {
            NetworkTools.sleep(Conf.DOWNLOAD_DELAY_SECONDS);
            processPage(link);
        }
    }

}
