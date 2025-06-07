package ap.exercises.ex6.SC3;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    public static String getHtmlContent(String html) {
        return html; // چون ما چیزی parse نمی‌کنیم
    }

    public static Set<String> extractUrls(String html) {
        Set<String> urls = new HashSet<>();
        Pattern pattern = Pattern.compile("href\\s*=\\s*\"(http[^\"]+)\"");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            urls.add(matcher.group(1));
        }
        return urls;
    }

    public static Set<String> extractImageUrls(String html) {
        Set<String> urls = new HashSet<>();
        Pattern pattern = Pattern.compile("img[^>]+src\\s*=\\s*\"(http[^\"]+)\"");
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            urls.add(matcher.group(1));
        }
        return urls;
    }

    public static Set<String> extractAudioUrls(String html) {
        Set<String> urls = new HashSet<>();
        Pattern pattern = Pattern.compile("<audio[^>]*>.*?<source[^>]+src\\s*=\\s*\"(http[^\"]+)\".*?>.*?</audio>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(html);
        while (matcher.find()) {
            urls.add(matcher.group(1));
        }
        return urls;
    }
}
