package com.iiitb.imageEffectApplication.effectImplementation;
import com.iiitb.imageEffectApplication.baseEffects.PhotoEffect;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.InvertInterface;

public class InvertImplementation implements PhotoEffect{
    public Pixel[][] apply(Pixel [][] image, String fileName, LoggingService lservice)
    {
        Pixel[][] new_image;
        // Use Runnable to run addLog and applyInvert simultaneously
        Runnable task = () -> {
            // Add log using a separate thread
            Thread logThreadi = new Thread(() -> lservice.addLog(fileName, "Invert", "Executed"));
            logThreadi.start();

            // Apply invert using a new thread (simultaneously with addLog)
            Thread invertThread = new Thread(() -> InvertInterface.applyInvert(image));
            invertThread.start();

            try {
                logThreadi.join();
                invertThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Run the task
        Thread taskThread = new Thread(task);
        taskThread.start();

        // Return the modified image
        new_image=InvertInterface.applyInvert(image);
        return new_image;
    }
}