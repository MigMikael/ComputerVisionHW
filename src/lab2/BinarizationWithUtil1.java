package lab2;

import Imageutil.Util;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 * Created by Mig on 2/21/2017.
 */
public class BinarizationWithUtil1 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int threshold = in.nextInt();

        String sourcePath = "C:\\Users\\Mig\\Documents\\EclipseProject\\ComputerVisionHW\\classical_building_small_gray.png";
        String destinationPath = "C:\\Users\\Mig\\Documents\\EclipseProject\\ComputerVisionHW\\output\\classical_building_small_gray1.png";
        int white = 255;
        int black = 0;

        // 1)
        BufferedImage img = Util.readImage(sourcePath);
        // 2)
        int[][] a = Util.loadToArray(img);

        // 3) change pixel value in array by threshold
        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if(a[row][col] < threshold)
                    a[row][col] = black;
                else
                    a[row][col] = white;
            }
        }

        // 4) copy pixel value FROM array TO image
        Util.saveToImage(a, img);

        // 5)
        Util.writeImage(destinationPath, img);
    }
}
