package ImageUtil;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mig on 2/8/2017.
 */
public class Util {

    public static BufferedImage readImage(String imagePath){
        BufferedImage img = null;
        File imgFile = new File(imagePath);
        try {
            img = ImageIO.read(imgFile);
            //System.out.println("Read Complete");

        } catch (IOException e) {
            System.err.println("Error load image");

        }
        return img;
    }

    public static void writeImage(String imagePath, BufferedImage img){
        File file = new File(imagePath);
        try {
            ImageIO.write(img, "png", file);
            //System.out.println("Write Complete");

        } catch (IOException e) {
            System.err.println("Error write image");
        }
    }

    public static int[][] loadToArray(BufferedImage img){
        WritableRaster raster = img.getRaster();
        int height = img.getHeight();
        int width = img.getWidth();
        int[][] a = new int[height][width];

        int[] pixelBuffer = new int[1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                raster.getPixel(col, row, pixelBuffer);
                a[row][col] = pixelBuffer[0];
            }
        }
        return a;
    }

    public static void loadToImage(int[][] a, BufferedImage img){
        WritableRaster raster = img.getRaster();
        int height = img.getHeight();
        int width = img.getWidth();
        int[] pixelBuffer = new int[1];

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pixelBuffer[0] = a[row][col];
                raster.setPixel(col, row, pixelBuffer);
            }
        }
    }
}
