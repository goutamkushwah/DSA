import java.util.LinkedList;

public class Chaining {
    int size;
    LinkedList<Integer>[] table;

    public Chaining(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    int hash(int key) {
        return key % size;
    }

    // Insert key
    void insert(int key) {
        int idx = hash(key);
        table[idx].add(key);
        System.out.println(key + " inserted at index " + idx);
    }

    // Search key
    boolean search(int key) {
        int idx = hash(key);
        if (table[idx].contains(key)) {
            System.out.println(key + " found at index " + idx);
            return true;
        } else {
            System.out.println(key + " not found in the hash table");
            return false;
        }
    }

    // Delete key
    void delete(int key) {
        int idx = hash(key);
        if (table[idx].remove(Integer.valueOf(key))) {
            System.out.println(key + " deleted from index " + idx);
        } else {
            System.out.println(key + " not found in the hash table");
        }
    }

    // Display hash table
    void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < size; i++) {
            System.out.print(i + " : ");
            for (int key : table[i]) {
                System.out.print(key + " -> ");
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Chaining ht = new Chaining(10); // ✅ Provide size here

        ht.insert(10);
        ht.insert(20);
        ht.insert(30);
        ht.insert(25);

        ht.display();

        ht.search(20);
        ht.delete(20);
        ht.display();
    }
}
