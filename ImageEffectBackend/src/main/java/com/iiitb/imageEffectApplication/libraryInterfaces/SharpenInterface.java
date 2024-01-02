package com.iiitb.imageEffectApplication.libraryInterfaces;

public class SharpenInterface {
    static {
        String libraryPath = "C:\\Users\\T761\\OneDrive\\Desktop\\P2_project\\P2-2023-Project\\ImageEffectBackend\\src\\main\\resources\\SharpenLib.dll";
        LoadNativeLibrary.loadNativeLibrary(libraryPath); // Load the native library
    }

    public static native Pixel[][] applySharpen(Pixel[][] image, float amount); // Apply sharpen to the image
}
