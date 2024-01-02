#include <vector>
#include "Flip.h"

using namespace std;

vector<vector<Pixel>> flipImage(vector<vector<Pixel>> image, int hFlip, int vFlip) {
    // constructing a new image
    vector<vector<Pixel>> newImage;

    int rSize = image.size();
    int cSize = image[0].size();

    for (int i = 0; i < rSize; i++) {
        vector<Pixel> newRow;

        // ensuring that the row index is flipped if the 
        // image is to be vertically flipped
        if (vFlip) {
            i = rSize-1-i;
        }

        for (int j = 0; j < cSize; j++) {
            if (hFlip) {
                j = cSize-1-j;
            }

            // ensuring that the column index is flipped if
            // the image is to be horizontally flipped
            newRow.push_back(image[i][j]);

            if (hFlip) {
                j = cSize-1-j;
            }
        }

        newImage.push_back(newRow);
        
        if (vFlip) {
            i = rSize-1-i;
        }
    }

    return newImage;
}