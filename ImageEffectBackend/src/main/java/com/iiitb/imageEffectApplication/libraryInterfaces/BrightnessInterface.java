package com.iiitb.imageEffectApplication.libraryInterfaces;

public class BrightnessInterface {
    static {
        String libraryPath = "C:\\Users\\T761\\OneDrive\\Desktop\\P2_project\\P2-2023-Project\\ImageEffectBackend\\src\\main\\resources\\BrightnessLib.dll"; // Path
                                                                                                                                                             // to
                                                                                                                                                             // the
                                                                                                                                                             // native
                                                                                                                                                             // library
        LoadNativeLibrary.loadNativeLibrary(libraryPath); // Load the native library
    }

    public static native Pixel[][] applyBrightness(Pixel[][] image, float amount); // Apply brightness to the image
    // native method used JNI to call the C++ method
}
