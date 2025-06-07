package ap.exercises.ex6.SC3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String domainAddress = Conf.DOMAIN_ADDRESS;
        String savePath = Conf.SAVE_DIRECTORY;
        DomainHtmlScraper scraper = new DomainHtmlScraper(domainAddress, savePath);
        scraper.start();
    }
}

