package lab2;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Imageutil.Util;

import javax.imageio.ImageIO;

/**
 * Created by Mig on 2/8/2017.
 */
public class ImageBinarization {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int threshold = in.nextInt();

        String sourcePath = "C:\\Users\\Mig\\Documents\\EclipseProject\\ComputerVisionHW\\classical_building_small_gray.png";
        String destinationPath = "C:\\Users\\Mig\\Documents\\EclipseProject\\ComputerVisionHW\\output\\classical_building_small_gray.png";

        BufferedImage img = null;

        try {
            File imgFile = new File(sourcePath);
            img = ImageIO.read(imgFile);
            //System.out.println("Read Complete...");
        } catch (IOException e) {
            System.err.println("Error load image");
        }

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

        int white = 255;
        int black = 0;

        //change pixel value in array by threshold
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if(a[row][col] < threshold)
                    a[row][col] = black;
                else
                    a[row][col] = white;
            }
        }

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                pixelBuffer[0] = a[row][col];
                raster.setPixel(col, row, pixelBuffer);
            }
        }

        File file = new File(destinationPath);
        try {
            ImageIO.write(img, "png", file);
            //System.out.println("Write Complete...");
        } catch (IOException e) {
            System.err.println("Error write image");
        }
    }
}
