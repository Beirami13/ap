package ap.exercises.ex6.SC2;

public class Main {
    public static void main(String[] args) {
        DomainHtmlScraper scraper = new DomainHtmlScraper(Conf.DOMAIN_ADDRESS, Conf.SAVE_DIRECTORY);
        scraper.start();
    }
}

