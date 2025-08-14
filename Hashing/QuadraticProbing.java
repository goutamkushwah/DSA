public class QuadraticProbing {
  int size = 10;
    int[] table = new int[size];
    public QuadraticProbing(){
        // Initialize table with -1 (means empty)
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }  
    int hash(int key) {
        return key % size;
    }
    // Insert key using quadratic probing
     void insert(int key) {
        int idx = hash(key);
        int i = 0;
        while (table[(idx + i * i) % size] != -1 && i < size) {
            i++;
        }
        if (i == size) {
            System.out.println("Hash table is full!");
            return;
        }
        int insertIdx = (idx + i * i) % size;
        table[insertIdx] = key;
        System.out.println(key + " inserted at index " + insertIdx);
    }

    // Search key using quadratic probing
    boolean search(int key) {
        int idx = hash(key);
        int i = 0;
        while (table[(idx + i * i) % size] != -1 && i < size) {
            if (table[(idx + i * i) % size] == key) {
                System.out.println(key + " found at index " + ((idx + i * i) % size));
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
        QuadraticProbing qp = new QuadraticProbing();
        qp.insert(10);
        qp.insert(20);
        qp.insert(30);
        qp.insert(25);
        qp.display();
        qp.search(20);
        qp.search(99);
    }
}