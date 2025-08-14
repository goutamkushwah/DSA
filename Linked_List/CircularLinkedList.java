import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    Node head = null;

    // Insert at beginning
    void insertBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Insert at end
    void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.next = head;
    }

    // Insert at position (0-based)
    void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        if (temp.next == head && position > 1) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete at beginning
    void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
    }

    // Delete at end
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    // Delete at position (0-based)
    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            deleteBeginning();
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        if (temp.next == head) {
            System.out.println("Position out of bounds");
            return;
        }
        temp.next = temp.next.next;
    }

    // Display the list
    void display() {
        if (head == null) {
            System.out.println("Circular Linked List is empty");
            return;
        }
        Node temp = head;
        System.out.print("Circular Linked List: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
    CircularLinkedList cll = new CircularLinkedList();
    Scanner sc = new Scanner(System.in);
    int choice, data, position;

    do {
        System.out.println("\n--- Circular Linked List Menu ---");
        System.out.println("1. Insert at End");
        System.out.println("2. Insert at Beginning");
        System.out.println("3. Insert at Position");
        System.out.println("4. Delete at Beginning");
        System.out.println("5. Delete at End");
        System.out.println("6. Delete at Position");
        System.out.println("7. Display");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter data: ");
                data = sc.nextInt();
                cll.insertEnd(data);
                break;
            case 2:
                System.out.print("Enter data: ");
                data = sc.nextInt();
                cll.insertBeginning(data);
                break;
            case 3:
                System.out.print("Enter data: ");
                data = sc.nextInt();
                System.out.print("Enter position: ");
                position = sc.nextInt();
                cll.insertAtPosition(data, position);
                break;
            case 4:
                cll.deleteBeginning();
                break;
            case 5:
                cll.deleteEnd();
                break;
            case 6:
                System.out.print("Enter position: ");
                position = sc.nextInt();
                cll.deleteAtPosition(position);
                break;
            case 7:
                cll.display();
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice!");
        }
    } while (choice != 0);
}
}