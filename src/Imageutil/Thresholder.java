package Imageutil;

/**
 * Created by Mig on 2/21/2017.
 */
public class Thresholder {
    public static void binarize(int[][] a, final int T, int outputLow, int outputHigh){

        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                if(a[row][col] < T)
                    a[row][col] = outputLow;
                else
                    a[row][col] = outputHigh;
            }
        }
    }
}
