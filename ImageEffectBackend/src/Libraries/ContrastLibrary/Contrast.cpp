#include <vector>
#include "Contrast.h"

using namespace std;

void apply_contrast_cpp(vector<vector<Pixel>> &imageVector, float amount) {
    int rows = imageVector.size();
    int cols = imageVector[0].size();

    // Adjusting the contrast to between 0.5 and 1.5
    float contrast1 = 0.5+amount/200;
    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            imageVector[i][j].r = min(255,max(0,static_cast<int>((imageVector[i][j].r-128)*contrast1+128)));
            imageVector[i][j].g = min(255,max(0,static_cast<int>((imageVector[i][j].g-128)*contrast1+128)));
            imageVector[i][j].b = min(255,max(0,static_cast<int>((imageVector[i][j].b-128)*contrast1+128)));
        }
    }
}
