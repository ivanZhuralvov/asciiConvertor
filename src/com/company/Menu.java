package com.company;

import java.util.Scanner;

public class Menu implements Appearance{

    private String filePathToOpen;
    private GrlImage imagge;

    @Override
    public void show() { // show the menu
        int res=-1;
        while (res!=0){
            System.out.println("-**************************  ( ͡° ͜ʖ ͡°)  ************  Menu  *****************-");
            System.out.println("Enter yout action:\n\t1.Add path\n\t0.Exit");
            Scanner in = new Scanner(System.in);
            res = in.nextInt();
            switch (res){
                case 1: addPath();
                    break;
                case 0: return;
            }
        }
    }

    private void addPath() {  // adds the file path to open the file
        System.out.println("Enter file path to open: \t(tip:do not forget to add extension to it .png or .jpg)");
        Scanner in = new Scanner(System.in);
        filePathToOpen = in.nextLine(); // do not forget extension of file .png or .jpg
        imagge = new GrlImage();
        imagge.load(filePathToOpen);
    }
}
