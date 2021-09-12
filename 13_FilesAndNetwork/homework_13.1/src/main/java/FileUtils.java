import java.io.File;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        return dirSize(new File(path));
    }
    private static long dirSize(File file) {
        long size;
        if (file.isDirectory()) {
            size = 0;
                for (File child : file.listFiles()) {
                    size += dirSize(child);
                }
        } else {
            size = file.length();
        }
        return size;
    }
}

