package the.stack.of.ancient.texts;

import java.util.Stack;

public class ScrollStack {
    private Stack<String> scrolls;

    public ScrollStack() {
        this.scrolls = new Stack<>();
    }

    // Push a new scroll onto the stack
    public void pushScroll(String title) {
        scrolls.push(title);
        System.out.println("Added scroll: " + title);
    }

    // Pop the top scroll off the stack
    public String popScroll() {
        if (!scrolls.isEmpty()) {
            String removedScroll = scrolls.pop();
            System.out.println("Removed scroll: " + removedScroll);
            return removedScroll;
        } else {
            System.out.println("The stack is empty. No scroll to remove.");
            return null;
        }
    }

    // Peek at the top scroll without removing it
    public String peekScroll() {
        if (!scrolls.isEmpty()) {
            String topScroll = scrolls.peek();
            System.out.println("Top scroll: " + topScroll);
            return topScroll;
        } else {
            System.out.println("The stack is empty. No scroll to peek.");
            return null;
        }
    }

    // Check if a specific scroll title exists in the stack
    public boolean containsScroll(String title) {
        boolean exists = scrolls.contains(title);
        if (exists) {
            System.out.println("The scroll titled \"" + title + "\" exists in the stack.");
        } else {
            System.out.println("The scroll titled \"" + title + "\" does not exist in the stack.");
        }
        return exists;
    }

    // Main method for testing the ScrollStack class
    public static void main(String[] args) {
        ScrollStack myScrollStack = new ScrollStack();
        
        myScrollStack.pushScroll("The Epic of Gilgamesh");
        myScrollStack.pushScroll("The Iliad");
        myScrollStack.pushScroll("The Odyssey");

        myScrollStack.peekScroll(); // Should display the top scroll

        myScrollStack.containsScroll("The Iliad"); // Check for a specific scroll
        myScrollStack.containsScroll("Hamlet"); // Check for a non-existing scroll

        myScrollStack.popScroll(); // Remove the top scroll
        myScrollStack.popScroll(); // Remove another scroll
        myScrollStack.popScroll(); // Remove the last scroll
        myScrollStack.popScroll(); // Try to pop from an empty stack
    }
}
