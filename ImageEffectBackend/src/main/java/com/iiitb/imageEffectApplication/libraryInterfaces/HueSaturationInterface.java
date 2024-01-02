package com.iiitb.imageEffectApplication.libraryInterfaces;

public class HueSaturationInterface {
    static {
        String libraryPath = "HueSaturationLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath); // Load the native library
    }

    public static native Pixel[][] applyHueSaturation(Pixel[][] image, float saturationValue, float hueValue);
    // native method used JNI to call the C++ method
}
