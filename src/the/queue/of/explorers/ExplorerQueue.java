package the.queue.of.explorers;

public class ExplorerQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    // Constructor to initialize the queue
    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new String[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue new explorers
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("The queue is full. Cannot add explorer: " + explorer);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = explorer;
        size++;
        System.out.println("Enqueued explorer: " + explorer);
    }

    // Dequeue explorers when they enter the temple
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorer to dequeue.");
            return null;
        }
        String removedExplorer = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Dequeued explorer: " + removedExplorer);
        return removedExplorer;
    }

    // Display the next explorer in line
    public String peekNextExplorer() {
        if (isEmpty()) {
            System.out.println("The queue is empty. No explorer in line.");
            return null;
        }
        String nextExplorer = queue[front];
        System.out.println("Next explorer in line: " + nextExplorer);
        return nextExplorer;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Main method for testing the ExplorerQueue class
    public static void main(String[] args) {
        ExplorerQueue explorerQueue = new ExplorerQueue(3); // Capacity of 3

        explorerQueue.enqueue("Explorer A");
        explorerQueue.enqueue("Explorer B");
        explorerQueue.enqueue("Explorer C");
        explorerQueue.enqueue("Explorer D"); // Should show the queue is full

        explorerQueue.peekNextExplorer(); // Display next explorer in line

        explorerQueue.dequeue(); // Remove an explorer
        explorerQueue.peekNextExplorer(); // Display next explorer in line after dequeue

        explorerQueue.dequeue(); // Remove another explorer
        explorerQueue.dequeue(); // Remove the last explorer
        explorerQueue.dequeue(); // Try to dequeue from an empty queue
    }
}

