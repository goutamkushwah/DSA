public class DoubleHashing {
    int size = 10;
    int[] table = new int[size];

    public DoubleHashing() {
        // Initialize table with -1 (means empty)
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    // First hash function
    int hash1(int key) {
        return key % size;
    }

    // Second hash function (should not return 0)
    int hash2(int key) {
        return 7 - (key % 7);
    }

    // Insert key using double hashing
    void insert(int key) {
        int idx = hash1(key);
        int step = hash2(key);
        int i = 0;
        while (table[(idx + i * step) % size] != -1 && i < size) {
            i++;
        }
        if (i == size) {
            System.out.println("Hash table is full!");
            return;
        }
        int insertIdx = (idx + i * step) % size;
        table[insertIdx] = key;
        System.out.println(key + " inserted at index " + insertIdx);
    }

    // Search key using double hashing
    boolean search(int key) {
        int idx = hash1(key);
        int step = hash2(key);
        int i = 0;
        while (table[(idx + i * step) % size] != -1 && i < size) {
            if (table[(idx + i * step) % size] == key) {
                System.out.println(key + " found at index " + ((idx + i * step) % size));
                return true;
            }
            i++;
        }
        System.out.println(key + " not found");
        return false;
    }

    // Display hash table
    void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " : " + (table[i] == -1 ? "empty" : table[i]));
        }
    }

    public static void main(String[] args) {
        DoubleHashing dh = new DoubleHashing();
        dh.insert(10);
        dh.insert(20);
        dh.insert(30);
        dh.insert(25);
        dh.display();
        dh.search(20);
        dh.search(99);
    }
}