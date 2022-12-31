package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindAndReplace {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //String filePath = "exercise/src/resources/";
        //String txtFormat = ".txt";
        //ask user for word to search
        System.out.println("What is the search word?");
        String searchWord = input.nextLine();

        //ask user to for word to be replaced
        System.out.println("What is the replacement word?");
        String replacementWord = input.nextLine();

        //ask user for source file to be read
        System.out.println("What is the source file?");
        String fileName = input.nextLine();

        System.out.println("What is the destination file?");
        String newFileName = input.nextLine();




        try {
            File file = new File(fileName);

            File newFile = new File(newFileName);
            newFile = file;



            FileWriter fWriter = new FileWriter(newFileName);
            BufferedWriter bWriter = new BufferedWriter(fWriter);
            Scanner fileScan = new Scanner(file);
            String line = " ";
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                bWriter.write(line.replace(searchWord, replacementWord));
                bWriter.newLine();
            }

            bWriter.flush();
            bWriter.close();
            fileScan.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());


        }

    }

}
