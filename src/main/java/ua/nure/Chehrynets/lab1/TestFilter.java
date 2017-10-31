package ua.nure.Chehrynets.lab1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class TestFilter {

    private static final String inputImagePath = "./beforeFilter.jpg";
    private static final String outputImagePath = "./afterFilter.jpg";
    private static final String outputImageAfterFilterPath = "./afterFilterX2.jpg";
    private static final String imageFormatName = "jpg";

    public static void main(String[] args) {
        File inputImageFile = new File(inputImagePath);
        File outputImageFile = new File(outputImagePath);
        try {
            BufferedImage image = ImageIO.read(inputImageFile);

            long start = System.currentTimeMillis();

            MedianFilter medianFilter = new MedianFilter(image, 1, image.getHeight());
            medianFilter.filter();
            System.out.println("Filter duration = " + (System.currentTimeMillis() - start) + " mls");
            ImageIO.write(image, imageFormatName, outputImageFile);

            start = System.currentTimeMillis();
            ParallelMedianFilter parallelMedianFilter = new ParallelMedianFilter();
            parallelMedianFilter.executeParallelFilter(image);
            parallelMedianFilter.shutDownExecutor();
            System.out.println("Parallel filter duration = " + (System.currentTimeMillis() - start) + " mls");
            ImageIO.write(image, imageFormatName, outputImageFile);

            BufferedImage imageAfterFilter = ImageIO.read(outputImageFile);
            MedianFilter median = new MedianFilter( imageAfterFilter, 1, imageAfterFilter.getHeight());
            median.filter();
            ImageIO.write(imageAfterFilter, imageFormatName, new File(outputImageAfterFilterPath));

        } catch (IOException | InterruptedException | ExecutionException ex) {
            System.out.printf(ex.getMessage());
        }

    }
}
