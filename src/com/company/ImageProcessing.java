package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProcessing implements Preview{
    private TextImage tImg;
    private String res = "";

    public String getRes() {
        return res;
    }

    public ImageProcessing(){
        tImg = new TextImage();
    }

    public void countingIntensivity(BufferedImage img){ // counts inentsivity of each pixel
        double pixval;
        for (int i = 0; i < img.getHeight(); i++) {
            for (int j = 0; j < img.getWidth(); j++) {
                Color pixcol = new Color(img.getRGB(j, i));
                pixval = (((pixcol.getRed() * 0.30) + (pixcol.getBlue() * 0.59) + (pixcol.getGreen() * 0.11)));
                res += findBestSuitableSymbol(pixval);
            }
            res += "\n";
        }
        tImg.setResult(res);
    }

    @Override
    public void createAsciiSymbols() { // runs a method in TextImage to see or save the result
        tImg.action();

    }

    private String findBestSuitableSymbol(double g) { // finds proper symbols according to their intensivity
        String str = " ";
        if (g >= 240) {
            str = " ";
        } else if (g >= 210) {
            str = ".";
        } else if (g >= 190) {
            str = "*";
        } else if (g >= 170) {
            str = "+";
        } else if (g >= 120) {
            str = "^";
        } else if (g >= 110) {
            str = "&";
        } else if (g >= 80) {
            str = "8";
        } else if (g >= 60) {
            str = "#";
        } else {
            str = "@";
        }
        return str;
    }

}
