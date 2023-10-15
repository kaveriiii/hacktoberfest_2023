class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new key into the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    // Search for a key in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.key == key) {
            return true;
        }

        if (key < root.key) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    // Inorder traversal of the BST
    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }
}

public class BSTExample {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        // Insert elements into the BST
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);

        // Search for elements
        System.out.println("Search for 40: " + tree.search(40));
        System.out.println("Search for 60: " + tree.search(60));

        // Inorder traversal
        System.out.print("Inorder traversal: ");
        tree.inorder();
    }
}
