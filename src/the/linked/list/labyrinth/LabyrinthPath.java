package the.linked.list.labyrinth;

public class LabyrinthPath {

    // Node class to represent each location in the path
    private static class Node {
        String location;
        Node next;

        public Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    private Node head; // Head of the linked list (start of the path)

    // Constructor to initialize the labyrinth path
    public LabyrinthPath() {
        this.head = null;
    }

    // 1. Add a new location to the path (to the end of the list)
    public void addLocation(String location) {
        Node newNode = new Node(location);

        if (head == null) {
            head = newNode; // If the list is empty, the new node becomes the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the end of the list
            }
            current.next = newNode; // Add the new node at the end
        }
    }

    // 2. Remove the last visited location (remove from the end of the list)
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("The path is empty. No location to remove.");
            return;
        }

        if (head.next == null) {
            // If there's only one location in the path
            head = null;
        } else {
            Node current = head;
            Node previous = null;

            while (current.next != null) {
                previous = current;
                current = current.next; // Traverse to the last node
            }
            previous.next = null; // Remove the last node
        }
    }

    // 3. Check if the path contains a loop (trap) using Floyd's Cycle-Finding Algorithm (Tortoise and Hare)
    public boolean containsLoop() {
        if (head == null) {
            return false; // Empty path cannot contain a loop
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow pointer by 1 step
            fast = fast.next.next;      // Move fast pointer by 2 steps

            if (slow == fast) {
                return true; // A loop is detected
            }
        }
        return false; // No loop detected
    }

    // 4. Print the entire path (traverse and print all locations)
    public void printPath() {
        if (head == null) {
            System.out.println("The path is empty.");
            return;
        }

        Node current = head;
        System.out.print("Labyrinth Path: ");
        while (current != null) {
            System.out.print(current.location + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        LabyrinthPath path = new LabyrinthPath();

        // Adding locations to the path
        path.addLocation("Entrance");
        path.addLocation("Hallway");
        path.addLocation("Chamber");
        path.addLocation("Dungeon");

        // Print the current path
        System.out.println("Current Path:");
        path.printPath();

        // Check for loop
        System.out.println("\nChecking if path contains a loop (trap):");
        boolean hasLoop = path.containsLoop();
        System.out.println(hasLoop ? "Path contains a loop!" : "No loop detected.");

        // Remove the last location
        System.out.println("\nRemoving the last location (Dungeon):");
        path.removeLastLocation();
        path.printPath();

        // Check loop again
        System.out.println("\nChecking if path contains a loop after removing last location:");
        hasLoop = path.containsLoop();
        System.out.println(hasLoop ? "Path contains a loop!" : "No loop detected.");

        // Optionally, create a loop for testing purposes
        // Uncomment the following lines to test loop detection
        /*
        System.out.println("\nCreating a loop in the path for testing...");
        createLoop(path);

        // Check for loop after manually creating one
        System.out.println("\nChecking if path contains a loop after creating a loop:");
        hasLoop = path.containsLoop();
        System.out.println(hasLoop ? "Path contains a loop!" : "No loop detected.");
        */
    }

    // Optional helper method to create a loop in the path for testing purposes
    private static void createLoop(LabyrinthPath path) {
        if (path.head == null) return;

        Node current = path.head;
        Node loopNode = null;
        int counter = 0;

        // Traverse and manually link the last node to the second node (creating a loop)
        while (current.next != null) {
            if (counter == 1) {
                loopNode = current; // Mark the second node as the loop entry point
            }
            current = current.next;
            counter++;
        }

        if (loopNode != null) {
            current.next = loopNode; // Create a loop
        }
    }
}
