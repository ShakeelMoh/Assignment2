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
    public void insertAVL(Data d) {
        root = insertAVL(d, root);
    }

    public BTNode insertAVL(Data d, BTNode node) {
        if (node == null) {
            return new BTNode(d, null, null);

        }
        if (d.getName().compareTo(node.getName()) <= 0) {
            node.left = insertAVL(d, node.left);
        } else {
            node.right = insertAVL(d, node.right);
        }
        return avl.balance(node);
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

    public void AVLdelete(String s) {
        root = AVLdelete(s, root);
    }

    public BTNode AVLdelete(String s, BTNode node) {
        if (node == null) {
            return null;
        }
        if (s.compareTo(node.getName()) < 0) {
            node.left = AVLdelete(s, node.left);
        } else if ((s).compareTo(node.getName()) > 0) {
            node.right = AVLdelete(s, node.right);
        } else {
            BTNode q = node.left;
            BTNode r = node.right;
            if (r == null) {
                return q;
            }
            BTNode min = findMin(r);
            min.right = removeMin(r);
            min.left = q;
            return avl.balance(min);
        }
        return avl.balance(node);
    }

    public BTNode BSTdelete(String s, BTNode node) {
        if (node == null) {
            System.out.println("Cannot delete " + s + " (Not found)");
            return null;
        }
        if (s.compareTo(node.getName()) < 0) {
            node.left = BSTdelete(s, node.left);
        } else if (s.compareTo(node.getName()) > 0) {
            node.right = BSTdelete(s, node.right);
        } else if (node.left != null && node.right != null) {

            String n = findMin(node.right).getName();
            String num = findMin(node.right).getNumber();
            String add = findMin(node.right).getAddress();

            node.setName(n);
            node.setName(num);
            node.setName(add);

            node.right = removeMin(node.right);
        } else if (node.left != null) {
            node = node.left;
        } else {
            node = node.right;
        }
        return node;
    }

    public BTNode findMin(BTNode node) {
        if (node != null) {
            while (node.left != null) {
                node = node.left;
            }
        }
        return node;
    }

    public BTNode removeMin(BTNode node) {
        if (node == null) {
            return null;
        } else if (node.left != null) {
            node.left = removeMin(node.left);
            return node;
        } else {
            return node.right;
        }
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

    public void postOrder() {

        postOrder(root);

    }

    public void postOrder(BTNode node) {

        if (node != null) {

            //visit left, right then parent
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.println(node.getName());

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
