package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the story:" );
        String FileName = input.nextLine();

        File story = new File(FileName);
        int lineNumber =1;

        try (Scanner filescanner = new Scanner(story)){
            while (filescanner.hasNextLine()){
                String line = filescanner.nextLine();
                System.out.printf("%2d: %s%n", lineNumber++, line);
            }

        }catch (FileNotFoundException e){
            System.out.println("The file \"" + FileName + "\" was not found. Please check the name and try again.");
        }
        input.close();
    }

}
