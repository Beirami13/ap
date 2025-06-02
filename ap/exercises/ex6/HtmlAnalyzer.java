package ap.exercises.ex6;

import java.util.*;
import java.util.stream.Collectors;

public class HtmlAnalyzer {
    private static final List<String> fileList = DirectoryTools.getFilesAbsolutePathInDirectory(Conf.SAVE_DIRECTORY);

    public static List<String> getAllUrls() {
        return fileList.stream()
                .map(FileTools::getTextFileLines)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .map(HtmlParser::getFirstUrl)
                .filter(s -> s != null && s.length() > 1)
                .toList();
    }

    public static List<String> getAllImageUrls() {
        return fileList.stream()
                .map(FileTools::getTextFileLines)
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .map(HtmlParser::getFirstImageUrl)
                .filter(s -> s != null && s.length() > 4)
                .toList();
    }

    public static void saveAllImageUrls(String path) {
        List<String> imageUrls = getAllImageUrls();
        FileTools.writeLinesToTextFile(path, imageUrls);
    }

    public static void printTopCountUrls(int k) {
        ObjectCounter counter = new ObjectCounter();
        getAllUrls().forEach(counter::add);
        for (Map.Entry<String, Integer> entry : counter.getTop(k)) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static List<String> getTopUrls(int k) {
        Map<String, Long> countMap = getAllUrls().stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        return countMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(k)
                .map(Map.Entry::getKey)
                .toList();
    }
}

