package ap.exercises.ex6.SC3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryTools {
    public static List<String> getFilesAbsolutePathInDirectory(String path){
        File directory = new File(path);
        File[] files = directory.listFiles();
        List<String> result = new ArrayList<>();
        if (files != null){
            for (File file : files){
                if (file.isFile()){
                    result.add(file.getAbsolutePath());
                }
            }
        }
        return result;
    }

    public static void makeDirectory(String path){
        File directory = new File(path);
        if (!directory.exists()){
            directory.mkdirs();
        }
    }
}

