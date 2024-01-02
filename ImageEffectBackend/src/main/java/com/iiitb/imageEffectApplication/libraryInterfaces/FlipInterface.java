package com.iiitb.imageEffectApplication.libraryInterfaces;




public class FlipInterface {
    static {
        String libraryPath = "C:\\Users\\T761\\OneDrive\\Desktop\\P2_project\\P2-2023-Project\\ImageEffectBackend\\src\\main\\resources\\FlipLib.dll";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }
    public static native Pixel[][] applyFlip(Pixel[][] image, int horizontalFlipValue, int verticalFlipValue);
}
