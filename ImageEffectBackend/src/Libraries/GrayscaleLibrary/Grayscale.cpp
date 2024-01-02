#include <vector>
#include "Grayscale.h"

#define MAX(a, b) a > b ? a : b
#define MIN(a, b) a < b ? a : b

using namespace std;

// a function to limit the value of 'val' from 0 to k
int truncate(int val, int k) {
    if (val >= k) {
        return k;
    }
    else if (val <= 0) {
        return 0;
    }
    else {
        return val;
    }
}

vector<vector<Pixel>> grayScaleImage(vector<vector<Pixel>> image) {
    // constructing a new image
    vector<vector<Pixel>> newImage;

    int i = 0;

    for (vector<Pixel> row: image) {
        vector<Pixel> newRow;
        for (Pixel pixel: row) {
            Pixel newPixel;

            int max = MAX(MAX(pixel.r, pixel.g), pixel.b);
            int min = MIN(MIN(pixel.r, pixel.g), pixel.b);
            float l = (max+min)/2.0;

            // // assuming the value of amt ranges from 0 to 2
            // // (this is the portion of the code where the grayscale effect
            // // is applied)
            newPixel.r = truncate(l, 255);
            newPixel.g = truncate(l, 255);
            newPixel.b = truncate(l, 255);

            // adding it into the new image
            newRow.push_back(newPixel);
        }
        newImage.push_back(newRow);
    }

    return newImage;
}