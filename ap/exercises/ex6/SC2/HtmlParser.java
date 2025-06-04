package ap.exercises.ex6.SC2;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HtmlParser {
    private static final Pattern linkPattern = Pattern.compile("href\\s*=\\s*\"(https?://[^\"]+)\"");
    private static final Pattern imgPattern = Pattern.compile("<img[^>]+src\\s*=\\s*\"(https?://[^\"]+)\"");

    public static List<String> extractLinks(String html) {
        Matcher matcher = linkPattern.matcher(html);
        return matcher.results()
                .map(m -> m.group(1))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<String> extractImageLinks(String html) {
        Matcher matcher = imgPattern.matcher(html);
        return matcher.results()
                .map(m -> m.group(1))
                .distinct()
                .collect(Collectors.toList());
    }
}

