/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaimagesGUI;

import java.awt.color.*;
import java.awt.image.*;

/**
 *
 * @author RaúlGonzález Cruz
 * email: raul.gonzalezcz@udlap.mx
 */
class SimpleImage {
    public static BufferedImage toGrayscale(BufferedImage processedImage) { 
     BufferedImage tempImage = new BufferedImage(processedImage.getWidth(), processedImage.getHeight(), processedImage.getType()); 
     BufferedImageOp op = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);  
     tempImage = op.filter(processedImage, null);  
     return tempImage; 
}   


public static BufferedImage convolutionFilter(BufferedImage processedImage, float[][] filter2D) {     
    BufferedImage tempImage = new BufferedImage(processedImage.getWidth(), processedImage.getHeight(), processedImage.getType()); 
    int columns = filter2D.length; 
    int  rows= filter2D[0].length; 
    //Unrolls a 2D filter into a 1D filter 
    float[] filter1D = new float[columns*rows]; 
    for (int j = 0; j<rows; j++) { 
            for (int i= 0; i< columns; i++ ) { 
            filter1D[j*columns + i] = filter2D[j][i]; 
        } 
    } 
    //creates Kernal and convolution operator 
    Kernel kern = new Kernel(rows, columns, filter1D); 
    ConvolveOp op = new ConvolveOp(kern); 
    //apply filtering  
    tempImage = op.filter(processedImage, null); 
    return tempImage; 

    } 
    
}
