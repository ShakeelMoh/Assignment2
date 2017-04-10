package Assign2;

public class BTNode {

    //Instance variables of a node
    BTNode left;
    BTNode right;
    int height;

    String address;
    String name;
    String number;

    public BTNode() {

    }

    public BTNode(Data d) {

        left = null;
        right = null;
        height = 0;

        name = d.getName();
        number = d.getNumber();
        address = d.getAddress();

    }

    //Get children nodes
    public BTNode getLeft() {

        return left;

    }

    public BTNode getRight() {

        return right;

    }

    //Returns a nodes data neatly formatted in a table format
    public String getData() {

        System.out.format("|%-30s   |%-30s   |%-55s   |", name, number, address, "");
        return "";
        //String output = name + "\t\t" + number + "\t\t" + address;
        //return output;

    }

    
    //Getters and setters
    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

}
