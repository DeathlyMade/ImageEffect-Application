package com.iiitb.imageEffectApplication.effectImplementation;
import com.iiitb.imageEffectApplication.baseEffects.SingleValueDiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.BrightnessInterface;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.RotationInterface;

public class RotationImplementation implements SingleValueDiscreteEffect{
    private int value=0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService lservice) {
        Pixel[][] new_image;
        // Use Runnable to run addLog and applyRotation simultaneously
        Runnable task = () -> {
            // Add log using a separate thread
            Thread logThreadr = new Thread(() -> lservice.addLog(fileName, "Rotation", String.valueOf(value)));
            logThreadr.start();

            // Apply rotation using a new thread (simultaneously with addLog)
            Thread rotationThread = new Thread(() -> RotationInterface.applyRotation(image, value));
            rotationThread.start();

            try {
                logThreadr.join();
                rotationThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Run the task
        Thread taskThread = new Thread(task);
        taskThread.start();

        // Return the modified image
        new_image=RotationInterface.applyRotation(image, value);
        return new_image;
    }
    public void setParameterValue(int parameterValue) throws IllegalParameterException
    {
        try{
            if(parameterValue==1 || parameterValue==2 || parameterValue==3 || parameterValue==0)
            {
                value=90*parameterValue;
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