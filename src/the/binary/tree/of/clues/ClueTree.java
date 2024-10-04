package the.binary.tree.of.clues;

public class ClueTree {
    private class Node {
        String clue;
        Node left, right;

        Node(String clue) {
            this.clue = clue;
            left = right = null;
        }
    }

    private Node root;

    // Insert a new clue
    public void insert(String clue) {
        root = insertRec(root, clue);
    }

    private Node insertRec(Node root, String clue) {
        if (root == null) {
            root = new Node(clue);
            return root;
        }
        if (clue.compareTo(root.clue) < 0) {
            root.left = insertRec(root.left, clue);
        } else if (clue.compareTo(root.clue) > 0) {
            root.right = insertRec(root.right, clue);
        }
        return root;
    }

    // Perform in-order traversal
    public void inOrder() {
        System.out.print("In-order traversal: ");
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.clue + " ");
            inOrderRec(root.right);
        }
    }

    // Perform pre-order traversal
    public void preOrder() {
        System.out.print("Pre-order traversal: ");
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.clue + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Perform post-order traversal
    public void postOrder() {
        System.out.print("Post-order traversal: ");
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.clue + " ");
        }
    }

    // Find a specific clue in the tree
    public boolean findClue(String clue) {
        return findClueRec(root, clue);
    }

    private boolean findClueRec(Node root, String clue) {
        if (root == null) {
            return false;
        }
        if (root.clue.equals(clue)) {
            return true;
        }
        return clue.compareTo(root.clue) < 0 ? findClueRec(root.left, clue) : findClueRec(root.right, clue);
    }

    // Count the total number of clues in the tree
    public int countClues() {
        return countCluesRec(root);
    }

    private int countCluesRec(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countCluesRec(root.left) + countCluesRec(root.right);
    }

    // Main method for testing the ClueTree class
    public static void main(String[] args) {
        ClueTree clueTree = new ClueTree();
        
        // Inserting clues
        clueTree.insert("Treasure Map");
        clueTree.insert("Hidden Door");
        clueTree.insert("Secret Passage");
        clueTree.insert("Ancient Key");
        clueTree.insert("Forgotten Tomb");

        // Perform traversals
        clueTree.inOrder();     // Should display clues in sorted order
        clueTree.preOrder();    // Should display clues in pre-order
        clueTree.postOrder();   // Should display clues in post-order

        // Find specific clues
        System.out.println("Finding 'Ancient Key': " + clueTree.findClue("Ancient Key")); // Should return true
        System.out.println("Finding 'Lost Artifact': " + clueTree.findClue("Lost Artifact")); // Should return false

        // Count total clues
        System.out.println("Total number of clues: " + clueTree.countClues()); // Should return the number of inserted clues
    }
}

