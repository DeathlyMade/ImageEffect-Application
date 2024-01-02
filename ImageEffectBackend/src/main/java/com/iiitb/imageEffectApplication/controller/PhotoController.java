package com.iiitb.imageEffectApplication.controller;

import com.iiitb.imageEffectApplication.service.PhotoEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/effect")
public class PhotoController {
    // This class is responsible for handling requests related to photo effects.
    @Autowired
    private PhotoEffectService photoEffectService; // Service used to handle photo effect-related requests

    @PostMapping("/hue-saturation") // This method handles POST requests to /effect/hue-saturation
    public ResponseEntity<byte[]> applyHueSaturationEffect(
            @RequestParam("hueAmount") float hueAmount, // The amount of hue to be applied
            @RequestParam("saturationAmount") float saturationAmount, // The amount of saturation to be applied
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applyHueSaturationEffect(hueAmount, saturationAmount, imageFile); // Apply the effect
                                                                                                    // and return the
                                                                                                    // response
    }

    @PostMapping("/brightness") // This method handles POST requests to /effect/brightness
    public ResponseEntity<byte[]> applyBrightnessEffect(
            @RequestParam("amount") float amount, // The amount of brightness to be applied
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applyBrightnessEffect(amount, imageFile); // Apply the effect and return the response
    }

    @PostMapping("/contrast") // This method handles POST requests to /effect/contrast
    public ResponseEntity<byte[]> applyContrastEffect( // The amount of contrast to be applied
            @RequestParam("amount") float amount, // The image file to apply the effect on
            @RequestParam("imageFile") MultipartFile imageFile) {
        return photoEffectService.applyContrastEffect(amount, imageFile); // Apply the effect and return the response
    }

    @PostMapping("/flip") // This method handles POST requests to /effect/flip
    public ResponseEntity<byte[]> applyFlipEffect(
            @RequestParam("horizontalFlipValue") int horizontalFlipValue, // The amount of horizontal flip to be applied
            @RequestParam("verticalFlipValue") int verticalFlipValue, // The amount of vertical flip to be applied
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applyFlipEffect(imageFile, horizontalFlipValue, verticalFlipValue); // Apply the
                                                                                                      // effect and
                                                                                                      // return the
                                                                                                      // response
    }

    @PostMapping("/gaussian-blur") // This method handles POST requests to /effect/gaussian-blur
    public ResponseEntity<byte[]> applyGaussianBlurEffect(
            @RequestParam("radius") float radius, // The radius of the blur
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applyGaussianBlurEffect(radius, imageFile); // Apply the effect and return the
                                                                              // response
    }

    @PostMapping("/grayscale") // This method handles POST requests to /effect/grayscale
    public ResponseEntity<byte[]> applyGrayscaleEffect( // The image file to apply the effect on
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applyGrayscaleEffect(imageFile); // Apply the effect and return the response
    }

    @PostMapping("/invert") // This method handles POST requests to /effect/invert
    public ResponseEntity<byte[]> applyInvertEffect(
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applyInvertEffect(imageFile);// Apply the effect and return the response
    }

    @PostMapping("/rotation") // This method handles POST requests to /effect/rotation
    public ResponseEntity<byte[]> applyRotationEffect(
            @RequestParam("value") int value, // The amount of rotation to be applied
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applyRotationEffect(value, imageFile); // Apply the effect and return the response
    }

    @PostMapping("/sepia") // This method handles POST requests to /effect/sepia
    public ResponseEntity<byte[]> applySepiaEffect(
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applySepiaEffect(imageFile); // Apply the effect and return the response
    }

    @PostMapping("/sharpen") // This method handles POST requests to /effect/sharpen
    public ResponseEntity<byte[]> applySharpenEffect(
            @RequestParam("amount") float amount, // The amount of sharpen to be applied
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.applySharpenEffect(amount, imageFile); // Apply the effect and return the response
    }

    @PostMapping("/dominant-colour") // This method handles POST requests to /effect/dominant-colour
    public ResponseEntity<byte[]> getDominantColour(
            @RequestParam("imageFile") MultipartFile imageFile // The image file to apply the effect on
    ) {
        return photoEffectService.getDominantColour(imageFile); // Apply the effect and return the response
    }

}
