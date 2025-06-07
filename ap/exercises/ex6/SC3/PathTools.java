package ap.exercises.ex6.SC3;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class PathTools {

    public static String getHtmlSavePath(String urlStr, String saveDirectory) {
        String filename = sanitizeFilename(urlStr) + ".html";
        String dir = saveDirectory + File.separator + "html";
        createDirIfNotExists(dir);
        return dir + File.separator + filename;
    }

    public static String getImageSavePath(String urlStr, String saveDirectory) {
        String filename = sanitizeFilename(urlStr);
        String dir = saveDirectory + File.separator + "image";
        createDirIfNotExists(dir);
        return dir + File.separator + filename;
    }

    public static String getAudioSavePath(String urlStr, String saveDirectory) {
        String filename = sanitizeFilename(urlStr);
        String dir = saveDirectory + File.separator + "song";
        createDirIfNotExists(dir);
        return dir + File.separator + filename;
    }

    private static void createDirIfNotExists(String dir) {
        File folder = new File(dir);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    private static String sanitizeFilename(String urlStr) {
        try {
            URL url = new URL(urlStr);
            String path = url.getPath();
            if (path == null || path.isEmpty() || path.equals("/")) {
                return url.getHost();
            }
            String sanitized = path.replaceAll("[\\\\/:*?\"<>|]", "_");
            if (sanitized.startsWith("/")) sanitized = sanitized.substring(1);
            if (sanitized.isEmpty()) sanitized = url.getHost();
            return sanitized;
        } catch (MalformedURLException e) {
            return urlStr.replaceAll("[\\\\/:*?\"<>|]", "_");
        }
    }
}
