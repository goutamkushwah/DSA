import java.util.*;

class HuffmanNode {
    int freq;
    char ch;
    HuffmanNode left, right;

    HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    HuffmanNode(int freq, HuffmanNode left, HuffmanNode right) {
        this.ch = '\0';
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

// For PriorityQueue: smallest frequency has highest priority
class CompareNode implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.freq - y.freq;
    }
}

public class Huffman {

    public static void printCodes(HuffmanNode root, String code) {
        if (root == null) return;

        // Leaf node: print character and code
        if (root.left == null && root.right == null && root.ch != '\0') {
            System.out.println(root.ch + ": " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        String text = "huffman";

        // Step 1: Count frequencies
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Create priority queue (min heap)
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(new CompareNode());
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Step 3: Build Huffman Tree
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode merged = new HuffmanNode(left.freq + right.freq, left, right);
            pq.add(merged);
        }

        // Step 4: Print codes
        HuffmanNode root = pq.poll();
        System.out.println("Huffman Codes:");
        printCodes(root, "");
    }
}
 