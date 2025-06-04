package ap.exercises.ex6.SC2;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTools {
    public static String getSavePathFromUrl(String url, String baseDir) {
        try {
            URL u = new URL(url);
            String host = u.getHost();
            String path = u.getPath();

            String domain = "znu.ac.ir";
            String subdomain = "";

            if (!host.equals(domain) && host.endsWith(domain)) {
                subdomain = "_" + host.substring(0, host.length() - domain.length() - 1);
            }

            Path fullPath = subdomain.isEmpty() ?
                    Paths.get(baseDir + path) :
                    Paths.get(baseDir, subdomain + path);

            if (!fullPath.toString().endsWith(".html")) {
                fullPath = Paths.get(fullPath.toString() + ".html");
            }

            return fullPath.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
