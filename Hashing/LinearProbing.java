public class LinearProbing {
     int size = 10;
    int[] table = new int[size];

    public LinearProbing() {
        // Initialize table with -1 (means empty)
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    int hash(int key) {
        return key % size;
    }

    // Insert key using linear probing
    void insert(int key) {
        int idx = hash(key);
        int startIdx = idx;

        while (table[idx] != -1) {
            idx = (idx + 1) % size; // Linear probing
            if (idx == startIdx) {
                System.out.println("Hash table is full");
                return;
            }
        }

        table[idx] = key;
        System.out.println(key + " inserted at index " + idx);
    }

    // Search key
    boolean search(int key) {
        int idx = hash(key);
        int startIdx = idx;

        while (table[idx] != -1) {
            if (table[idx] == key) {
                System.out.println(key + " found at index " + idx);
                return true;
            }
            idx = (idx + 1) % size;
            if (idx == startIdx) break; // Avoid infinite loop
        }

        System.out.println(key + " not found in the hash table");
        return false;
    }

    // Display hash table
    void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " : " + (table[i] == -1 ? "Empty" : table[i]));
        }
    }

    public static void main(String[] args) {
        LinearProbing ht = new LinearProbing();
        ht.insert(10);
        ht.insert(20);
        ht.insert(30);
        ht.insert(25);
        ht.display();
        ht.search(20);
        ht.search(99);
    }
}

