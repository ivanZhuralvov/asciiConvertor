package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextImage implements Appearance,Preview{
    private String result = "";
    private PrintWriter prntWrt;
    private FileWriter fileWrt;


    public void setResult(String result) {
        this.result = result;
    }

    public void action(){ // allows us to chose what we would like to do with converted picture
        int res=-1;
        while (res!=0) {
            System.out.println("What would you like to do:\n\t1.See the result\n\t2.Save\n\t0.Back to menu");
            Scanner in = new Scanner(System.in);
            res = in.nextInt();
            switch (res){
                case 1: show();
                    break;
                case 2: createAsciiSymbols();
                    break;
            }
        }
    }

    @Override
    public void show() { // shows the result
        System.out.println(result);
    }

    @Override
    public void createAsciiSymbols() {
        String fileName="file.txt";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter txt file name:\t \t(tip:do not forget to add extension to it .txt) "); // do not forget file extension .txt
        fileName = in.nextLine();

        if(fileName.equals("")){
            fileName="file.txt";
        }

        try {
            prntWrt = new PrintWriter(fileWrt = new FileWriter(fileName, true));
        } catch (IOException ex) {
        }


        // spreading existing sting of result into array of lines
        // so we can write in appropriate way
        String[] tempArrayOfLines = result.lines().toArray(String[]::new); // temp array of lines

        for (int i = 0; i < tempArrayOfLines.length ; i++) {
            try {
                prntWrt.print(tempArrayOfLines[i]);
                prntWrt.println("");
                prntWrt.flush();
                fileWrt.flush();
            } catch (Exception ex) {
            }

        }

    }

}
