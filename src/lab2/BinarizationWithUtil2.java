package lab2;

import Imageutil.Thresholder;
import Imageutil.Util;

import java.awt.image.BufferedImage;
import java.util.Scanner;

/**
 * Created by Mig on 2/21/2017.
 */
public class BinarizationWithUtil2 {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int threshold = in.nextInt();

        String basePath = "C:\\Users\\Mig\\Documents\\EclipseProject\\ComputerVisionHW\\";

        String sourcePath = basePath + "classical_building_small_gray.png";
        String destinationPath = basePath + "\\output\\classical_building_small_gray2.png";

        int white = 255;
        int black = 0;

        // 1) Load image to BufferedImage
        BufferedImage img = Util.readImage(sourcePath);

        // 2) Copy pixel value FROM img TO array
        int[][] a = Util.loadToArray(img);

        // 3) change pixel value in array by threshold
        Thresholder.binarize(a, threshold, black, white);

        // 4) Copy pixel value FROM array TO image
        Util.saveToImage(a, img);

        // 5) Write image to destinationPath
        Util.writeImage(destinationPath, img);
    }

}
