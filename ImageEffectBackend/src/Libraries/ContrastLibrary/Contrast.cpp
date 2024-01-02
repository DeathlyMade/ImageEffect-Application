#include <vector>
#include "Contrast.h"

using namespace std;

void apply_contrast_cpp(vector<vector<Pixel>> imageVector, float amount) {
    int rows = imageVector.size();
    int cols = imageVector[0].size();
    float minIntensity = 255.0;
    float maxIntensity = 0.0;

    // Adjusting the contrast to range from 0.5 to 1.5
    float contrast = 0.5+amount/200;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            // applying the contrast to each pixel and truncating the values from 0 to 255
            imageVector[i][j].r = min(255,max(0,static_cast<int>((imageVector[i][j].r-128) * contrast + 128)));
            imageVector[i][j].g = min(255,max(0,static_cast<int>((imageVector[i][j].g-128) * contrast + 128)));
            imageVector[i][j].b = min(255,max(0,static_cast<int>((imageVector[i][j].b-128) * contrast + 128)));
        }
    }
}
