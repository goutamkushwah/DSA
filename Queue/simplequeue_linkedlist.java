class Node{
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class simplequeue_linkedlist {
Node front,rear;
public simplequeue_linkedlist() {
front = rear = null; 
}
// Enqueue operation
void enqueue(int item){
Node newNode = new Node(item);
if(rear == null ){
    front =rear = newNode;
    }
    else{
        rear.next= newNode;
        rear = newNode;
    }
     System.out.println(item + " enqueued to queue");
}
// Dequeue operation
int dequeue(){
    if(front == null){
        System.out.println("Queue Underflow");
        return -1;
    }
    int item = front.data;
    front = front.next;
    if(front == null) {
        rear = null; // If the queue is now empty
    }
    return item;
}
// Display queue elements
void display(){
    if(front == null) {
        System.out.println("Queue is Empty");
        return;
    }
    Node current = front;
    System.out.print("Queue elements: ");
    while(current != null) {
        System.out.print(current.data + " ");
        current = current.next;
    }
    System.out.println();
}
public static void main(String[] args) {
    simplequeue_linkedlist q = new simplequeue_linkedlist();
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.display();
    System.out.println(q.dequeue() + " dequeued from queue");
    q.display();
    System.out.println(q.dequeue() + " dequeued from queue");
}
}