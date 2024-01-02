package com.iiitb.imageEffectApplication.effectImplementation;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.SepiaInterface;

public class SepiaImplementation implements PhotoEffect{
    public Pixel[][] apply(Pixel [][] image, String fileName, LoggingService lservice)
    {
        Pixel[][] new_image;
        // Use Runnable to run addLog and applySepia simultaneously
        Runnable task = () -> {
            // Add log using a separate thread
            Thread logThreadsep = new Thread(() -> lservice.addLog(fileName, "Sepia", "Executed"));
            logThreadsep.start();

            // Apply sepia using a new thread (simultaneously with addLog)
            Thread sepiaThread = new Thread(() -> SepiaInterface.applySepia(image));
            sepiaThread.start();

            try {
                logThreadsep.join();
                sepiaThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Run the task
        Thread taskThread = new Thread(task);
        taskThread.start();

        // Return the modified image
        new_image=SepiaInterface.applySepia(image);
        return new_image;
    }


}