import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.Callable;

import org.imgscalr.Scalr;


public class ImageResizer {
    private File file;
    private int newWidth;
    private String dstFolder;

    public ImageResizer(File file, int newWidth, String dstFolder) {
        this.file = file;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;

        try {
            BufferedImage image = ImageIO.read(file);

            int newHeight = (int) Math.round(
                    image.getHeight() / (image.getWidth() / (double) newWidth)
            );

            BufferedImage newImage = resize(image, newWidth, newHeight);

            File newFile = new File(dstFolder + "/" + file.getName());
            ImageIO.write(newImage, "jpg", newFile);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("!");
    }

    public static BufferedImage resize(BufferedImage src, int targetWidth, int targetHeight){
        return Scalr.resize(src,
                Scalr.Method.ULTRA_QUALITY,
                Scalr.Mode.FIT_EXACT,
                targetWidth,
                targetHeight);
    }
}
