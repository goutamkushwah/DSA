import java.util.Scanner;

class Node{
    int data;
    Node next,prev;
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class DoublyLinkedList {
   Node head;
    // Insert at beginning
void insertBeginning(int data){
    Node newNode = new Node(data);
    if (head != null) {
        newNode.next = head;
        head.prev = newNode;
    }
    head = newNode;
}

    // Insert at end
    void insertEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }
    // Insert at position
    void insertAtPosition(int data, int position) {
        if (position == 0) {
            insertBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }
    // Delete at beginning
    void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }
    // Delete at end
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }
    // Delete at position
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
        for (int i = 0; i < position && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
    }
    // Display the list
    void display() {
        Node temp = head;
        System.out.print("Doubly Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    // Display forward
    void displayForward() {
        Node temp = head;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Display backward
    void displayBackward() {
        if (head == null) {
            System.out.println("Backward: List is empty");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.print("Backward: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
    DoublyLinkedList list = new DoublyLinkedList();
    Scanner sc = new Scanner(System.in);
    int choice, data, position;

    do {
        System.out.println("\n*** Doubly Linked List Operations ***");
        System.out.println("1. Insert at Beginning");
        System.out.println("2. Insert at End");
        System.out.println("3. Insert at Position");
        System.out.println("4. Delete from Beginning");
        System.out.println("5. Delete from End");
        System.out.println("6. Delete from Position");
        System.out.println("7. Display Forward");
        System.out.println("8. Display Backward");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter data: ");
                data = sc.nextInt();
                list.insertBeginning(data);
                break;

            case 2:
                System.out.print("Enter data: ");
                data = sc.nextInt();
                list.insertEnd(data);
                break;

            case 3:
                System.out.print("Enter data: ");
                data = sc.nextInt();
                System.out.print("Enter position: ");
                position = sc.nextInt();
                list.insertAtPosition(data, position);
                break;

            case 4:
                list.deleteBeginning();
                break;

            case 5:
                list.deleteEnd();
                break;

            case 6:
                System.out.print("Enter position: ");
                position = sc.nextInt();
                list.deleteAtPosition(position);
                break;

            case 7:
                list.displayForward();
                break;

            case 8:
                list.displayBackward();
                break;

            case 0:
                System.out.println("Exiting...");
                break;

            default:
                System.out.println("Invalid choice. Try again.");
        }
    } while (choice != 0);

    sc.close();
    }
}
