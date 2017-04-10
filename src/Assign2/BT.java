package Assign2;

public class BT {

    //Specify the root of the tree as "root"
    static BTNode root;

    //Create instance of binary tree node
    BTNode node = new BTNode();

    AVLTree avl = new AVLTree();

    //Default constructor
    public BT() {

        root = null;

    }

    //Check if tree is empty
    public boolean isEmpty() {

        return root == null;

    }

    public void print() {

        System.out.println("Binary Tree Telephone Directory");
        System.out.println("-------------------------------\n");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|Name\t\t\t\t  |Number\t\t\t    |Address\t\t\t\t\t\t       |");
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");

        //In order print method
        this.inorder(this.getRoot());
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");

    }

    //Insert data into bst recursively
    public void insertAVL(BTNode node, Data d) {
        BTNode newNode = new BTNode(d);
        if (root == null) {
            root = newNode;
            avl.balance(node);
            return;
        }
        BTNode current = root;
        BTNode parent = null;

        while (true) {
            parent = current;
            if (d.getName().compareTo(current.getName()) < 0) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    avl.balance(node);
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    avl.balance(node);
                    return;
                }
            }
        }

    }

    //Insert data into bst recursively
    public void insertBST(BTNode node, Data d) {
        BTNode newNode = new BTNode(d);
        if (root == null) {
            root = newNode;
            return;
        }
        BTNode current = root;
        BTNode parent = null;

        while (true) {
            parent = current;
            if (d.getName().compareTo(current.getName()) < 0) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }

    }

    //Search bst for specific name
    public boolean find(String name) {

        if (root == null) {
            System.out.println("No root found");
            return false;
        } else {
            return find(root, name);
        }

    }

    public boolean find(BTNode r, String name) {

        if (r.getName().compareTo(name) == 0) {
            System.out.println(r.getData());
            return true;
        } else if (r.getName().compareTo(name) > 0) {

            if (r.left != null) {
                return find(r.left, name);
            }

        } else {
            if (r.right != null) {
                return find(r.right, name);
            }

        }
        System.out.println("|" + name + ": Not found");
        return false;
    }
    
        
   public BTNode delete (String s, BTNode node )
   {
      if (node == null) return null;
      if (s.compareTo (node.getName()) < 0)
         node.left = delete (s, node.left);
      else if (s.compareTo (node.getName()) > 0)
         node.right = delete (s, node.right);
      else
      {
         BTNode q = node.left;
         BTNode r = node.right;
         if (r == null)
            return q;
         BTNode min = avl.findMin (r);
         min.right = avl.removeMin (r);
         min.left = q;
         return avl.balance (min);
      }
      return avl.balance (node);
   }

    //Print bst in inorder fashion
    public void inorder() {

        inorder(root);
    }

    public void inorder(BTNode r) {

        if (r != null) {

            inorder(r.getLeft());

            System.out.print(r.getData() + "\n");

            inorder(r.getRight());

        }

    }

    //Return root of bst
    public BTNode getRoot() {
        return root;
    }

    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(BTNode node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
        }
    }

    public int getSize() {
        return getSize(root);
    }

    public int getSize(BTNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getSize(node.getLeft()) + getSize(node.getRight());
        }
    }

}
