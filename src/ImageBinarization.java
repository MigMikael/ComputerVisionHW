import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Scanner;
import ImageUtil.Util;

/**
 * Created by Mig on 2/8/2017.
 */
public class ImageBinarization {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int threshold = in.nextInt();
        int white = 255;
        int black = 0;

        String sourcePath = "C:\\Users\\Mig\\Documents\\EclipseProject\\ComputerVisionHW\\classical_building_small_gray.png";
        String destinationPath = "C:\\Users\\Mig\\Documents\\EclipseProject\\ComputerVisionHW\\output\\classical_building_small_gray.png";

        BufferedImage img = Util.readImage(sourcePath);
        int height = img.getHeight();
        int width = img.getWidth();

        //copy pixel value FROM img TO array
        int[][] a = Util.loadToArray(img);

        //change pixel value in array by threshold
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if(a[row][col] < threshold)
                    a[row][col] = black;
                else
                    a[row][col] = white;
            }
        }

        //copy pixel value FROM array TO image
        Util.loadToImage(a, img);

        Util.writeImage(destinationPath, img);
    }
}
