import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        String srcFolder = "src_images";
        String dstFolder = "dst_images";
        int newWidth = 300;

        File[] files = new File(srcFolder).listFiles();

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(() -> {
            for (int i = 0; i < files.length; i++){
                ImageResizer resizer = new ImageResizer(files[i], newWidth, dstFolder);
                resizer.run();
            }
        });
    }
}
