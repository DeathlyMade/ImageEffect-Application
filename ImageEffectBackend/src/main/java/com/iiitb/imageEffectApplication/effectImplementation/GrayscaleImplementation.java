package com.iiitb.imageEffectApplication.effectImplementation;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.GrayscaleInterface;

public class GrayscaleImplementation implements PhotoEffect{
    public Pixel[][] apply(Pixel [][] image, String fileName, LoggingService lservice)
    {
        Pixel[][] new_image;
        Runnable task = () -> {
            // Add log using a separate thread
            Thread logThread = new Thread(() -> lservice.addLog(fileName, "GrayScale", "Executed"));
            logThread.start();

            // Apply brightness using a new thread (simultaneously with addLog)
            Thread GrayScaleThread = new Thread(() -> GrayscaleInterface.applyGrayscale(image));
            GrayScaleThread.start();

            try {
                logThread.join();
                GrayScaleThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Run the task
        Thread taskThread = new Thread(task);
        taskThread.start();

        // Return the modified image
        new_image=GrayscaleInterface.applyGrayscale(image);
        return new_image;
        // lservice.addLog(fileName, "GrayScale", "Executed");
        // return GrayscaleInterface.applyGrayscale(image);
    }
}