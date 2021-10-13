import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "src_images";
        String dstFolder = "dst_images";
        int newWidth = 300;

        File[] files = new File(srcFolder).listFiles();

        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(() -> {
            ImageResizer resizer = new ImageResizer(files, newWidth, dstFolder);
            resizer.run();
        });
        service.shutdown();
    }
}
