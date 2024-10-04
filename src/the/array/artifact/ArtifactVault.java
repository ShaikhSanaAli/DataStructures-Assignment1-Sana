package the.array.artifact;
import java.util.Arrays;

public class ArtifactVault {

    // Inner class to represent an Artifact
    public static class Artifact implements Comparable<Artifact> {
        private String name;
        private int age; // Age of the artifact (used for sorting)

        public Artifact(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Artifact{name='" + name + "', age=" + age + "}";
        }

        @Override
        public int compareTo(Artifact other) {
            return Integer.compare(this.age, other.age);
        }
    }

    private Artifact[] artifacts;
    private int size;

    // Constructor to initialize the vault with a given capacity
    public ArtifactVault(int capacity) {
        artifacts = new Artifact[capacity];
        size = 0;
    }

    // 1. Add an artifact to the first empty slot
    public boolean addArtifact(String name, int age) {
        if (size == artifacts.length) {
            System.out.println("Vault is full. Cannot add more artifacts.");
            return false;
        }
        artifacts[size] = new Artifact(name, age);
        size++;
        Arrays.sort(artifacts, 0, size); // Sort the array by age after adding
        return true;
    }

    // 2. Remove an artifact by its name
    public boolean removeArtifact(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i] != null && artifacts[i].getName().equals(name)) {
                // Shift elements left after removing
                for (int j = i; j < size - 1; j++) {
                    artifacts[j] = artifacts[j + 1];
                }
                artifacts[size - 1] = null;
                size--;
                return true;
            }
        }
        System.out.println("Artifact not found.");
        return false;
    }

    // 3. Find an artifact using linear search
    public Artifact linearSearch(String name) {
        for (int i = 0; i < size; i++) {
            if (artifacts[i] != null && artifacts[i].getName().equals(name)) {
                return artifacts[i];
            }
        }
        return null; // Not found
    }

    // 4. Find an artifact using binary search (assuming the array is sorted by age)
    public Artifact binarySearch(int age) {
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (artifacts[mid].getAge() == age) {
                return artifacts[mid];
            } else if (artifacts[mid].getAge() < age) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // Not found
    }

    // Utility function to print the current state of the vault
    public void printVault() {
        System.out.println("Current Artifacts in Vault:");
        for (int i = 0; i < size; i++) {
            System.out.println(artifacts[i]);
        }
    }

    public static void main(String[] args) {
        ArtifactVault vault = new ArtifactVault(5);

        // Adding artifacts
        vault.addArtifact("Sword", 1200);
        vault.addArtifact("Shield", 1000);
        vault.addArtifact("Amulet", 1400);

        vault.printVault();

        // Finding an artifact using linear search
        System.out.println("\nFinding 'Shield' using linear search:");
        Artifact foundArtifact = vault.linearSearch("Shield");
        System.out.println(foundArtifact != null ? foundArtifact : "Artifact not found.");

        // Finding an artifact using binary search
        System.out.println("\nFinding artifact with age 1400 using binary search:");
        Artifact foundByAge = vault.binarySearch(1400);
        System.out.println(foundByAge != null ? foundByAge : "Artifact not found.");

        // Removing an artifact
        System.out.println("\nRemoving 'Sword' from the vault:");
        boolean removed = vault.removeArtifact("Sword");
        System.out.println(removed ? "Sword removed successfully." : "Sword not found.");
        
        vault.printVault();
    }
}

