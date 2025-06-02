package ap.exercises.ex6;

public class HtmlParser {

    public static String getFirstUrl(String line) {
        int hrefIndex = line.indexOf("href=");
        if (hrefIndex == -1) return null;

        int startQuote = line.indexOf("\"", hrefIndex);
        int endQuote = line.indexOf("\"", startQuote + 1);

        if (startQuote != -1 && endQuote != -1) {
            return line.substring(startQuote + 1, endQuote);
        }
        return null;
    }

    public static String getFirstImageUrl(String line) {
        int imgIndex = line.indexOf("<img");
        if (imgIndex == -1) return null;

        int srcIndex = line.indexOf("src=", imgIndex);
        if (srcIndex == -1) return null;

        int startQuote = line.indexOf("\"", srcIndex);
        int endQuote = line.indexOf("\"", startQuote + 1);

        if (startQuote != -1 && endQuote != -1) {
            return line.substring(startQuote + 1, endQuote);
        }
        return null;
    }
}

