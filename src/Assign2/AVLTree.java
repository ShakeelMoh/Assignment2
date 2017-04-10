package Assign2;

public class AVLTree {
    
    static BTNode btn;
    static BT bt;

    public int height(BTNode node) {
        if (node != null) {
            return node.height;
        }
        return -1;
    }

    public int balanceFactor(BTNode node) {
        return height(node.right) - height(node.left);
    }

    public void fixHeight(BTNode node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

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



    public BTNode findMin(BTNode node) {
        if (node.left != null) {
            return findMin(node.left);
        } else {
            return node;
        }
    }

    public BTNode removeMin(BTNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = removeMin(node.left);
        return balance(node);
    }

    public void treeOrder() {
        treeOrder(bt.getRoot(), 0);
    }

    public void treeOrder(BTNode node, int level) {
        if (node != null) {
            for (int i = 0; i < level; i++) {
                System.out.print(" ");
            }
            System.out.println(node.getData());
            treeOrder(node.left, level + 1);
            treeOrder(node.right, level + 1);
        }
    }
}
