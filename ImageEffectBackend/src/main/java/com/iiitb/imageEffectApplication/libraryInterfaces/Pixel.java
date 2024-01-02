package com.iiitb.imageEffectApplication.libraryInterfaces;

/**
 * Represents a pixel in an image with red, green, and blue color components.
 */
public class Pixel {
    private int r, g, b;

    /**
     * Constructs a new Pixel object with the specified red, green, and blue color
     * components.
     *
     * @param r the red color component
     * @param g the green color component
     * @param b the blue color component
     */
    public Pixel(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Returns the red color component of the pixel.
     *
     * @return the red color component
     */
    public int getR() {
        return r;
    }

    /**
     * Returns the green color component of the pixel.
     *
     * @return the green color component
     */
    public int getG() {
        return g;
    }

    /**
     * Returns the blue color component of the pixel.
     *
     * @return the blue color component
     */
    public int getB() {
        return b;
    }

    /**
     * Sets the red color component of the pixel.
     *
     * @param r the red color component to set
     */
    public void setR(int r) {
        this.r = r;
    }

    /**
     * Sets the green color component of the pixel.
     *
     * @param g the green color component to set
     */
    public void setG(int g) {
        this.g = g;
    }

    /**
     * Sets the blue color component of the pixel.
     *
     * @param b the blue color component to set
     */
    public void setB(int b) {
        this.b = b;
    }
}
