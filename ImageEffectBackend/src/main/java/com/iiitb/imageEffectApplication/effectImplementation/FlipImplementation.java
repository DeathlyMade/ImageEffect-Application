package com.iiitb.imageEffectApplication.effectImplementation;

import com.iiitb.imageEffectApplication.baseEffects.DiscreteEffect;
import com.iiitb.imageEffectApplication.exception.IllegalParameterException;
import com.iiitb.imageEffectApplication.service.LoggingService;
import com.iiitb.imageEffectApplication.libraryInterfaces.Pixel;
import com.iiitb.imageEffectApplication.libraryInterfaces.FlipInterface;

public class FlipImplementation implements DiscreteEffect {
    private int hzflipval = 0, vertflipval = 0;

    public Pixel[][] apply(Pixel[][] image, String fileName, LoggingService lservice) {
        Pixel[][] new_image;
        if (hzflipval == 0 && vertflipval == 1) {
            Runnable task = () -> {
                // Add log using a separate thread
                Thread logThread = new Thread(() -> lservice.addLog(fileName, "Flip", "Vertical Flip"));
                logThread.start();

                // Apply brightness using a new thread (simultaneously with addLog)
                Thread VerticalFlipThread = new Thread(() -> FlipInterface.applyFlip(image, hzflipval, vertflipval));
                VerticalFlipThread.start();

                try {
                    logThread.join();
                    VerticalFlipThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            // Run the task
            Thread taskThread = new Thread(task);
            taskThread.start();

            // Return the modified image
            new_image = FlipInterface.applyFlip(image, hzflipval, vertflipval);
            // lservice.addLog(fileName, "Flip", "Vertical Flip");
        } else if (hzflipval == 1 && vertflipval == 0) {
            Runnable task = () -> {
                // Add log using a separate thread
                Thread logThread = new Thread(() -> lservice.addLog(fileName, "Flip", "Horizontal Flip"));
                logThread.start();

                // Apply brightness using a new thread (simultaneously with addLog)
                Thread HorizontalFlipThread = new Thread(() -> FlipInterface.applyFlip(image, hzflipval, vertflipval));
                HorizontalFlipThread.start();

                try {
                    logThread.join();
                    HorizontalFlipThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            // Run the task
            Thread taskThread = new Thread(task);
            taskThread.start();

            // Return the modified image
            new_image = FlipInterface.applyFlip(image, hzflipval, vertflipval);
            // lservice.addLog(fileName, "Flip", "Horizontal Flip");
        } else if (hzflipval == 1 && vertflipval == 1) {
            Runnable task = () -> {
                // Add log using a separate thread
                Thread logThread = new Thread(() -> lservice.addLog(fileName, "Flip", "Vertical and Horizontal Flip"));
                logThread.start();

                // Apply brightness using a new thread (simultaneously with addLog)
                Thread BothFlipThread = new Thread(() -> FlipInterface.applyFlip(image, hzflipval, vertflipval));
                BothFlipThread.start();

                try {
                    logThread.join();
                    BothFlipThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            // Run the task
            Thread taskThread = new Thread(task);
            taskThread.start();

            // Return the modified image
            new_image = FlipInterface.applyFlip(image, hzflipval, vertflipval);
            // lservice.addLog(fileName, "Flip", "Vertical and Horizontal Flip");
        } else {
            Runnable task = () -> {
                // Add log using a separate thread
                Thread logThread = new Thread(() -> lservice.addLog(fileName, "Flip", "No Flip"));
                logThread.start();

                // Apply brightness using a new thread (simultaneously with addLog)
                Thread NoFlipThread = new Thread(() -> FlipInterface.applyFlip(image, hzflipval, vertflipval));
                NoFlipThread.start();

                try {
                    logThread.join();
                    NoFlipThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            // Run the task
            Thread taskThread = new Thread(task);
            taskThread.start();

            // Return the modified image
            new_image = FlipInterface.applyFlip(image, hzflipval, vertflipval);
            // lservice.addLog(fileName, "Flip", "No Flip");
        }
        return new_image;
        // return FlipInterface.applyFlip(image,hzflipval,vertflipval);
    }

    public void selectOptionValue(String optname, int v) throws IllegalParameterException {
        try {
            if (optname.equals("Horizontal") && (v == 0 || v == 1)) {
                hzflipval = v;
            } else if (optname.equals("Vertical") && (v == 0 || v == 1)) {
                vertflipval = v;
            } else {
                throw new IllegalParameterException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}