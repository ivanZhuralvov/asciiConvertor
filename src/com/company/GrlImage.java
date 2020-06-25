package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GrlImage implements Appearance{
    private ImageProcessing iPro;
    private BufferedImage img;

    @Override
    public void show() { // shows the info about image that we have loaded
        System.out.println(img);
    }

    public void load(String fileName){ // loads an image to the program and
        try {
            img = ImageIO.read(new File(fileName));
        } catch (IOException e) {
        }
        show();
        iPro = new ImageProcessing();
        iPro.countingIntensivity(img);
        iPro.createAsciiSymbols();
    }





}
