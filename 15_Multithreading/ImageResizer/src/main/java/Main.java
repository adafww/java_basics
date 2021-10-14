import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "src_images";
        String dstFolder = "dst_images";
        int newWidth = 300;

        File[] files = new File(srcFolder).listFiles();

        ExecutorService service = Executors.newFixedThreadPool(8);
        service.submit(() -> {
            new ImageResizer(files, newWidth, dstFolder);
        });
        service.shutdown();
    }
}
