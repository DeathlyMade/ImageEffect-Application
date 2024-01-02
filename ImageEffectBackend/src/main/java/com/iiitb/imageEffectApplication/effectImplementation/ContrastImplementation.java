package com.iiitb.imageEffectApplication.effectImplementation;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueParameterizableEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.ContrastInterface;

public class ContrastImplementation implements SingleValueParameterizableEffect{
    private float amount=0.0f;
    public Pixel[][] apply(Pixel [][] image, String fileName, LoggingService lservice)
    {
        Pixel[][] new_image;
        Runnable task = () -> {
            // Add log using a separate thread
            Thread logThread = new Thread(() -> lservice.addLog(fileName, "Contrast", String.valueOf(amount)));
            logThread.start();

            // Apply brightness using a new thread (simultaneously with addLog)
            Thread ContrastThread = new Thread(() -> ContrastInterface.applyContrast(image, amount));
            ContrastThread.start();

            try {
                logThread.join();
                ContrastThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Run the task
        Thread taskThread = new Thread(task);
        taskThread.start();

        // Return the modified image
        new_image=ContrastInterface.applyContrast(image, amount);
        return new_image;
        // lservice.addLog(fileName, "Contrast", String.valueOf(amount));
        // return ContrastInterface.applyContrast(image,amount);
    }
    public void setParameterValue(float parameterValue) throws IllegalParameterException
    {
        try{
            if(amount>=0.0 && amount<=200.0)
            {
                amount=parameterValue;
            }
            else {
                throw new IllegalParameterException();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}