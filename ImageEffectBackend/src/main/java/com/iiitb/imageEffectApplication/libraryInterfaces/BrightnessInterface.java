package com.iiitb.imageEffectApplication.libraryInterfaces;

public class BrightnessInterface {
    static {
        String libraryPath = "C:\\Users\\T761\\OneDrive\\Desktop\\P2_project\\P2-2023-Project\\ImageEffectBackend\\src\\main\\resources\\BrightnessLib.dll";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyBrightness(Pixel[][] image, float amount);
}
