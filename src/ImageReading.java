import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import ImageUtil.Util;

public class ImageReading {
	
	public int[][] loadToArray(BufferedImage img){
		int width = img.getWidth();
		int height = img.getHeight();
		
		Raster raster = img.getRaster();
		int arImg[][] = new int[height][width];
		int[] pixelBuffer = new int[1];
		
		for (int row = 0; row < height; ++row) {
			for (int col = 0; col < width; ++col) {
				raster.getPixel(col, row, pixelBuffer);
				arImg[row][col] = pixelBuffer[0];
			}
		}
		
		return arImg;
	}
	
	public void printPixelValue(int[][] arImg){
		for (int i = 0; i < arImg.length; i++) {
			for (int j = 0; j < arImg[i].length; j++) {
				System.out.print(arImg[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public BufferedImage drawWhiteLine(BufferedImage img){
		int width = img.getWidth();
		int height = img.getHeight();
		int middleRow = height / 2;
		
		int white = 255;
		int pixel[] = new int[1];
		pixel[0] = white;
		
		WritableRaster writableRaster = img.getRaster();
		for (int col = 0; col < width; col++) {
			writableRaster.setPixel(col, middleRow, pixel);
		}
		
		return img;
	}
	
	public BufferedImage brightnessInverse(BufferedImage img){
		int width = img.getWidth();
		int height = img.getHeight();
		
		WritableRaster wriRaster = img.getRaster();
		int[] currentPixel = new int[1];
		int[] newPixel = new int[1];
		
		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				wriRaster.getPixel(col, row, currentPixel);
				newPixel[0] = 255 - currentPixel[0]; 
				wriRaster.setPixel(col, row, newPixel);
			}
		}
		
		return img;
	}

	public static void main(String args[]){
		String p = "C:\\Users\\Mig\\Documents\\EclipseProject\\ComputerVisionHW\\";
		
		String sourcePath = p + "classical_building_small_gray.png";
		String sourcePath2 = p + "gray.png";
		String sourcePath3 = p + "gray_150.png";
		String sourcePath4 = p + "silpakorn.png";
		
		// java.lang.NullPointerException when getHeight() or getWidth()
		String sourcePath5 = "ConsecSale.png";
		
		String destinationPath = p + "output\\gray.png";
		String destinationPath2 = p + "output\\slipakorn.png";
		String destinationPath3 = p + "output\\classical_building_small_gray.png";
	
		/*
		ImageReading reader = new ImageReading();
		BufferedImage img = reader.readBufferedImage(sourcePath3);
		img = reader.drawWhiteLine(img);
		reader.writeBufferedImage(img, destinationPath);
		
		int[][] arImg = reader.loadToArray(img);
		reader.printPixelValue(arImg);
		*/
		
		ImageReading reader = new ImageReading();
		BufferedImage img = Util.readImage(sourcePath);
		img = reader.brightnessInverse(img);
		Util.writeImage(destinationPath3, img);
	}
}
