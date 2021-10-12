import org.imgscalr.AsyncScalr;

import java.io.File;

public class Main {
    final static int CORE_COUNT = 8;

    public static void main(String[] args) {
        String srcFolder = "src_images";
        String dstFolder = "dst_images";
        int newWidth = 300;
        int count = 0;
        int coreCount = 0;

        boolean first = true;

        File[] files = new File(srcFolder).listFiles();

        int onePart = files.length / CORE_COUNT;
        int residual = files.length % CORE_COUNT;

        for (int i = 0; i < files.length; i++){
            if(count == onePart || first){
                if(coreCount == CORE_COUNT - 1){
                    onePart += residual;
                }
                File[] images = new File[onePart];
                System.arraycopy(files, coreCount * count, images, 0, onePart);
                ImageResizer resizer = new ImageResizer(images, newWidth, dstFolder);
                new Thread(resizer).start();
                coreCount++;
                count = 0;
                first = false;
            }
            count++;
        }
    }
}
