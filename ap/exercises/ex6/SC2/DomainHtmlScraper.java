package ap.exercises.ex6.SC2;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DomainHtmlScraper {
    private final String domain;
    private final String saveDirectory;
    private final Set<String> visitedUrls = new HashSet<>();

    public DomainHtmlScraper(String domain, String saveDirectory) {
        this.domain = domain;
        this.saveDirectory = saveDirectory;
    }

    public void start() {
        crawl(domain);
    }

    private void crawl(String url) {
        if (!isAllowedDomain(url) || visitedUrls.contains(url)) return;

        visitedUrls.add(url);
        String html = NetworkTools.downloadHtml(url);
        if (html == null) return;

        String path = PathTools.getSavePathFromUrl(url, saveDirectory);
        FileTools.writeTextToFile(path, html);

        List<String> images = HtmlParser.extractImageLinks(html);
        FileTools.writeLinesToTextFile(path + "_images.txt", images);

        List<String> links = HtmlParser.extractLinks(html);
        for (String link : links) crawl(link);
    }

    private boolean isAllowedDomain(String url) {
        try {
            String host = new URL(url).getHost();
            return host.endsWith("znu.ac.ir");
        } catch (Exception e) {
            return false;
        }
    }
}

