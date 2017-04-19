package Assign2;

import static Assign2.SearchAVL.avl;
import static Assign2.SearchAVL.bt;
import static Assign2.SearchAVL.insertFromFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchIt {

    static BTNode btn;
    static BT bt;

    public static void main(String[] args) {

        FillTree(); //Load data into bst

        ReadData r = new ReadData();
        r.read();

        Scanner sc = new Scanner(System.in);
        //String[] times = new String[4];
        //int count = 0;

        //System.out.println("Insert (I) Delete (D) Search (S)?");
        
        //while (count < 1){
            
            //String choice = sc.nextLine();
            String choice = "P";
        

            Instant start = Instant.now();

            if (choice.equals("S") || choice.equals("D")) {

                try {

                    //Read data from query file
                    sc = new Scanner(new File("/home/shakeel/NetBeansProjects/Assignment2/Data/QueryFile"));

                    String searchTerm;

                    //Format data into tabular format
                        if (choice.equals("S")){
                        System.out.println("Searching query file using BST (AVL) algorithm...\n\nResults:\n");
                        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
                        System.out.println("|Name\t\t\t\t  |Number\t\t\t    |Address\t\t\t\t\t\t       |");
                        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
                        }
                    while (sc.hasNext()) {

                        searchTerm = sc.nextLine();

                        if (choice.equals("S")) {
                            bt.find(bt.getRoot(), searchTerm);
                        }
                        if (choice.equals("D")) {
                            bt.BSTdelete(searchTerm, bt.getRoot());
                        }

                    }
                    //For formatting purposes
                    if(choice.equals("D")){
                            bt.print();
                        }
                        if (choice.equals("S")){
                            System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
                        }

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SearchIt.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (choice.equals("I")) {

                System.out.println("Inserting...");
                insertFromFile();
                //bt.print();
            } else {
                System.out.println("Invalid Input");
            }

            //Time program execution
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            //times[count] = timeElapsed.toMillis() + "";
            //count ++;

            System.out.println();

            System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");
        //}
        //System.out.println(times[0] + " " + times[1] + " " + times[2]);///////////////////////

    }

    public static void FillTree() {

        Data d;
        bt = new BT(); //Root becomes null

        //Reads the data line by line from the text file
        ReadData r = new ReadData();
        r.read();

        for (int i = 0; i < r.getListName().size(); i++) {

            d = new Data();

            //Define btn as the current node
            btn = new BTNode();

            d.name = r.getListName().get(i);
            d.number = r.getListNumber().get(i);
            d.address = r.getListAddress().get(i);

            btn.setName(d.getName());
            btn.setNumber(d.getNumber());
            btn.setAddress(d.getAddress());

            //Insert function from bt class
            //Insert btn, the new node with all its contents
            bt.insertBST(btn, d);

        }

    }

    public static void insertFromFile() {
        
        //Insert data from file into bst
        Data d;
        avl = new AVLTree();

        ReadData r = new ReadData();
        r.read("InsertData");

        for (int i = 0; i < r.getListName().size(); i++) {

            d = new Data();

            btn = new BTNode();

            d.name = r.getListName().get(i);
            d.number = r.getListNumber().get(i);
            d.address = r.getListAddress().get(i);

            btn.setName(d.getName());
            btn.setNumber(d.getNumber());
            btn.setAddress(d.getAddress());

            bt.insertBST(btn,d);

        }

    }

}
