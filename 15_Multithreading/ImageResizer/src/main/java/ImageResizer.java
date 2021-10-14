import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import org.imgscalr.Scalr;

public class ImageResizer {
    public ImageResizer(File[] files, int newWidth, String dstFolder) {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );

                BufferedImage newImage = resize(image, newWidth, newHeight);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
                System.out.println("!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static BufferedImage resize(BufferedImage src, int targetWidth, int targetHeight){
        return Scalr.resize(src,
                Scalr.Method.ULTRA_QUALITY,
                Scalr.Mode.FIT_EXACT,
                targetWidth,
                targetHeight);
    }
}
