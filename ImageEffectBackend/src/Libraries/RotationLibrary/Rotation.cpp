#include "Rotation.h"
#include <vector>
vector< vector< Pixel>> applyRotation(vector< vector< Pixel>> imageVector, int angle){
    //angle can only take values 0, 90, 180, 270
    if(angle==90){
        vector< vector< Pixel>> rotatedImageVector;
        for(int i=0;i<imageVector[0].size();i++){
            vector< Pixel> temp;
            for(int j=imageVector.size()-1;j>=0;j--){
                temp.push_back(imageVector[j][i]);
            }
            rotatedImageVector.push_back(temp);
        }
        return rotatedImageVector;
    }
    else if(angle==180){
        vector< vector< Pixel>> rotatedImageVector;
        for(int i=imageVector.size()-1;i>=0;i--){
            vector< Pixel> temp;
            for(int j=imageVector[i].size()-1;j>=0;j--){
                temp.push_back(imageVector[i][j]);
            }
            rotatedImageVector.push_back(temp);
        }
        return rotatedImageVector;
    }
    else if(angle==270){
        vector< vector< Pixel>> rotatedImageVector;
        for(int i=imageVector[0].size()-1;i>=0;i--){
            vector< Pixel> temp;
            for(int j=0;j<imageVector.size();j++){
                temp.push_back(imageVector[j][i]);
            }
            rotatedImageVector.push_back(temp);
        }
        return rotatedImageVector;
    }
    //returning same image if angle is 0 or invalid
    else{
        return imageVector;
    }
}