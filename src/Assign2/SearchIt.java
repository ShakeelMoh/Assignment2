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

        System.out.println("Insert (I) Delete (D) Search (S)?");
        String choice = sc.nextLine();

        Instant start = Instant.now();

        if (choice.equals("S") || choice.equals("D")) {

            try {

                //Read data from query file
                sc = new Scanner(new File("/home/shakeel/NetBeansProjects/Assignment2/Data/RandomNames/50000Names"));

                String searchTerm;

                //Format data into tabular format
                System.out.println("Searching query file using BST algorithm...\n\nResults:\n");
                System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
                System.out.println("|Name\t\t\t\t  |Number\t\t\t    |Address\t\t\t\t\t\t       |");
                System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
                while (sc.hasNext()) {

                    searchTerm = sc.nextLine();

                    if (choice.equals("S")) {
                        bt.find(bt.getRoot(), searchTerm);
                    }
                    if (choice.equals("D")) {
                        bt.BSTdelete(searchTerm, bt.getRoot());
                    }

                }
                System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(SearchIt.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (choice.equals("I")) {

            System.out.println("Inserting...");
            insertFromFile();
        } else {
            System.out.println("Invalid Input");
        }

        //Time program execution
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);

        System.out.println();

        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");

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
        System.out.println("Happens");
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

            bt.insertBST(btn, d);

        }

    }

}
