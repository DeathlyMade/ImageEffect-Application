package com.iiitb.imageEffectApplication.libraryInterfaces;

public class GaussianBlurInterface {
    static {
        String libraryPath = "GaussianBlurLib";
        LoadNativeLibrary.loadNativeLibrary(libraryPath); // Load the native library
    }

    public static native Pixel[][] applyGaussianBlur(Pixel[][] image, float radius);
    // native method used JNI to call the C++ method
}
