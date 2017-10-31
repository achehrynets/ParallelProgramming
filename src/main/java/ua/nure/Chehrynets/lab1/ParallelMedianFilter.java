package ua.nure.Chehrynets.lab1;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelMedianFilter {

    private static final int CORES = Runtime.getRuntime().availableProcessors();
    private ExecutorService executorService;

    public ParallelMedianFilter() {
        this.executorService = Executors.newFixedThreadPool(CORES);
    }

    public void shutDownExecutor() {
        executorService.shutdown();
    }

    public List<Future> executeParallelFilter(BufferedImage image) throws ExecutionException, InterruptedException{
        int usedThreads = image.getHeight() / CORES;
        List<Future> futures = new ArrayList<>();
        for (int i = 1; i < CORES + 1; i++) {
            if (i < CORES) {
                int finalI = i;
                futures.add(executorService.submit(new Runnable() {
                    public void run() {
                        new MedianFilter(image, usedThreads * (finalI - 1), usedThreads * (finalI + 1))
                                .filter();
                    }
                }));
            } else {
                int finalI1 = i;
                futures.add(executorService.submit(new Runnable() {
                    public void run() {
                        new MedianFilter(image, usedThreads * (finalI1 - 1), image.getHeight())
                                .filter();
                    }
                }));
            }
        }
        return futures;
    }

}
