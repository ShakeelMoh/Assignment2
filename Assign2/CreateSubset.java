package Assign2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shakeel
 */

//This class creates subsets of varying sizes of the original test data file. User can input how many items they want
//Subsets are genereated randomly but no duplicates are produced
public class CreateSubset {

    public static void main(String[] args) {

        //Read data from testdata
        ArrayList<Integer> unique = new ArrayList<>();

        PrintWriter pw = null;

        ReadData r = new ReadData();
        r.read();

        //Random number generation
        Random ran = new Random();

        //Choose how many random names you would like to print
        System.out.println("How many lines of data do you want??");

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        String fileName = count + "Entries";

        try {
            //Writes to a textfile
            pw = new PrintWriter(fileName);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreateSubset.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Genereates random number
        for (int i = 0; i < count; i++) {

            int randomNum = ran.nextInt(10000);

            if (unique.contains(randomNum)) {
                randomNum = ran.nextInt(10000);
            } else {
                unique.add(randomNum);
            }

            String output = r.getListAddress().get(randomNum)
                    + "|" + r.getListNumber().get(randomNum) + "|" + r.getListName().get(randomNum);
            pw.write(output + "\n");
            //System.out.println(output);

        }
        
        pw.close();

    }

}
