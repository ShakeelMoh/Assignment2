package Assign2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//Utility class which was used for the experiment
//Gets n names from the test data class and prints them out
//Makes algorithm testing easier with a specific number of queries
//Could produce duplicates*

//Creativity marks??

public class FindnNames {

    public static void main(String[] args) {

        //Read data from testdata
        ReadData r = new ReadData();
        r.read();

        //Random number generation
        Random ran = new Random();
        
        //Choose how many random names you would like to print
        System.out.println("How many names do you want?");

        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        
        for (int i = 0; i < count; i++) {

            String output = r.getListName().get(ran.nextInt(10000)) + "";
            System.out.println(output);

        }

    }

}
