import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

    public static long calculateFolderSize(String path) {

        Path paths = Paths.get(path);
        long size = 0;

        try (Stream<Path> init = Files.walk(paths)){
            size = init.filter(Files::isRegularFile).mapToLong(a -> {
                try {
                    return Files.size(a);
                }catch (IOException e){

                    e.getStackTrace();
                    return 0l;
                }
            }).sum();
        }catch (IOException ex){
            ex.getStackTrace();
        }
        return size;
    }
}
