package ua.nure.Chehrynets.lab1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main {

    public static final String inputImagePath = "./beforeFilter.jpg";
    public static final String outputImagePath = "./afterFilter.jpg";
    public static final String imageFormatName = "jpg";

    public static void main(String[] args) {
        File inputImageFile = new File(inputImagePath);
        File outputImageFile = new File(outputImagePath);
        try {
            BufferedImage image = ImageIO.read(inputImageFile);

            long start = System.currentTimeMillis();

            MedianFilter medianFilter = new MedianFilter();
            medianFilter.filter(image, 1, image.getHeight());
            System.out.println("Processing duration = " + (System.currentTimeMillis() - start) + " mls");
            ImageIO.write(image, imageFormatName, outputImageFile);

            start = System.currentTimeMillis();
            ParallelMedianFilter parallelMedianFilter = new ParallelMedianFilter();
            parallelMedianFilter.executeParallelFilter(image);
            parallelMedianFilter.shutDownExecutor();
            System.out.println("Parallel processing duration = " + (System.currentTimeMillis() - start) + " mls");
            ImageIO.write(image, imageFormatName, outputImageFile);

        } catch (IOException | InterruptedException | ExecutionException ex) {
            System.out.printf(ex.getMessage());
        }

    }
}
