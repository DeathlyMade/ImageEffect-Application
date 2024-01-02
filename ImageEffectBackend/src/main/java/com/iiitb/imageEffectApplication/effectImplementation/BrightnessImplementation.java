package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;

public class BrightnessImplementation implements SingleValueParameterizableEffect {
    private float amount = 0.0f;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService lservice) {
        Pixel[][] new_image;
        // Use Runnable to run addLog and applyBrightness simultaneously
        Runnable task = () -> {
            // Add log using a separate thread
            Thread logThread = new Thread(() -> lservice.addLog(fileName, "Brightness", String.valueOf(amount)));
            logThread.start();

            // Apply brightness using a new thread (simultaneously with addLog)
            Thread brightnessThread = new Thread(() -> BrightnessInterface.applyBrightness(image, amount));
            brightnessThread.start();

            try {
                logThread.join();
                brightnessThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Run the task
        Thread taskThread = new Thread(task);
        taskThread.start();
        new_image=BrightnessInterface.applyBrightness(image, amount);
        // Return the modified image
        return new_image;
    }

    public void setParameterValue(float parameterValue) throws IllegalParameterException {
        try {
            if (parameterValue >= 0.0 && parameterValue <= 200.0) {
                amount = parameterValue;
            } else {
                throw new IllegalParameterException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}