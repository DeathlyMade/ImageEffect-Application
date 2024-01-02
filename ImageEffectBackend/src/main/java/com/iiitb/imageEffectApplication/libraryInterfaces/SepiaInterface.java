package com.iiitb.imageEffectApplication.libraryInterfaces;




public class SepiaInterface {
    static {
        String libraryPath = "C:\\Users\\T761\\OneDrive\\Desktop\\P2_project\\P2-2023-Project\\ImageEffectBackend\\src\\main\\resources\\SepiaLib.dll";
        LoadNativeLibrary.loadNativeLibrary(libraryPath);
    }

    public static native Pixel[][] applySepia(Pixel[][] image);
}
