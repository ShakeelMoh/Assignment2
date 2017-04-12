/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assign2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shakeel
 */
public class SearchAVL {

    static BTNode btn;
    static BT bt;
    static AVLTree avl;

    public static void main(String[] args) {

        //Time program execution
        FillTree(); //Load data into bst

        ReadData r = new ReadData();
        r.read();

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert (I) Delete (D) Search (S) Print (P)?");
        String choice = sc.nextLine();

        Instant start = Instant.now();

        switch (choice) {
            case "S":
            case "D":
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

                            bt.AVLdelete(searchTerm);
                            

                        }

                    }
                    if(choice.equals("D")){
                        bt.print();
                    }
                    if (choice.equals("S")){
                        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SearchAVL.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "I":

                System.out.println("Inserting...");
                insertFromFile();
                bt.print();

                break;
            case "P":
                //System.out.println(avl.balanceFactor(bt.getRoot()));

                bt.print();
                break;
            default:
                
                
                System.out.println("Done");
                break;
                
                
        }

        //bt.print();
        //System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        //Time program execution
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println();
        System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");

    }

    public static void FillTree() {

        Data d;
        bt = new BT(); //Root becomes null
        avl = new AVLTree();

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
            bt.insertAVL(d);

        }

    }

    public static void insertFromFile() {

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

            bt.insertAVL(d);
        }

    }

}
