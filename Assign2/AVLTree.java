package Assign2;

//Class containing all the methods of maintaining a balanced avl tree
public class AVLTree {
    
    //Create instances of a binary tree node and a binary tree
    static BTNode btn;
    //..

    //Gets height of a node
    public int height(BTNode node) {
        if (node != null) {
            return node.height;
        }
        return -1;
    }

    //Determines whether a node is balanced or not
    public int balanceFactor(BTNode node) {
        return height(node.right) - height(node.left);
    }

    public void fixHeight(BTNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    //Rotations of the tree used when tree becomes unbalanced
    public BTNode rotateRight(BTNode p) {
        BTNode q = p.left;
        p.left = q.right;
        q.right = p;
        fixHeight(p);
        fixHeight(q);
        return q;
    }

    public BTNode rotateLeft(BTNode q) {
        BTNode p = q.right;
        q.right = p.left;
        p.left = q;
        fixHeight(q);
        fixHeight(p);
        return p;
    }

    //Function to balance the tree
    public BTNode balance(BTNode p) {
        fixHeight(p);
        if (balanceFactor(p) == 2) {
            if (balanceFactor(p.right) < 0) {
                p.right = rotateRight(p.right);
            }
            return rotateLeft(p);
        }
        if (balanceFactor(p) == -2) {
            if (balanceFactor(p.left) > 0) {
                p.left = rotateLeft(p.left);
            }
            return rotateRight(p);
        }
        return p;
    }


    //Find minimum node
    public BTNode findMin(BTNode node) {
        if (node.left != null) {
            return findMin(node.left);
        } else {
            return node;
        }
    }
    //Remove minimum node
    public BTNode removeMin(BTNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return balance(node);
    }

}
