import java.util.Scanner;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
public class SinglyLinkedList {
  Node head;
    // Method to insert a new node at the end of the list
   void insertBeginning(int data) {
    Node newNode = new Node(data);
    newNode.next = head;
    head = newNode;
}
void insertEnd(int data){
    Node newNode = new Node(data);
    if(head == null){
        head = newNode;
    }
    else{
        Node temp = head;
        while ((temp.next != null)) {
            temp = temp.next;            
        }
        temp.next = newNode;
    }
}
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
    temp.next = newNode;
}
void deleteBeginning(){
    if(head == null) {
        System.out.println("List is empty");
        return;
    }
    head = head.next;
}
void deleteEnd(){
    if(head == null) {
        System.out.println("List is empty");
        return;
    }
    if(head.next == null) {
        head = null;
        return;
    }
    Node temp = head;
    while(temp.next.next != null) {
        temp = temp.next;
    }
    temp.next = null;
}
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
    for (int i = 0; i < position - 1 && temp != null; i++) {
        temp = temp.next;
    }
    if (temp == null || temp.next == null) {
        System.out.println("Position out of bounds");
        return;
    }
    temp.next = temp.next.next; 
}
// Display the linked list
void display(){
Node temp = head;
System.out.print("Linked List: ");
while(temp !=null){
    System.out.print(temp.data + " ");
    temp = temp.next;
}
System.out.println();
}
 public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        Scanner sc = new Scanner(System.in);
        int choice, data, position;

        do {
            System.out.println("\n*** Linked List Operations ***");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Beginning");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display List");
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
                    list.display();
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