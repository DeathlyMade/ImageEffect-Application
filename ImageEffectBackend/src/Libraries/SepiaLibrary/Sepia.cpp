#include "Sepia.h"
#include <vector>
vector< vector< Pixel>> applySepia(vector< vector< Pixel>> imageVector){
    for(int i=0;i<imageVector.size();i++){
        for(int j=0;j<imageVector[i].size();j++){
            int r = imageVector[i][j].r;
            int g = imageVector[i][j].g;
            int b = imageVector[i][j].b;
            imageVector[i][j].r = min(255, (int)(0.393*r + 0.769*g + 0.189*b));
            imageVector[i][j].g = min(255, (int)(0.349*r + 0.686*g + 0.168*b));
            imageVector[i][j].b = min(255, (int)(0.272*r + 0.534*g + 0.131*b));
        }
    }
    return imageVector;
}