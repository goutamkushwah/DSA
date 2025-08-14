public class SimpleQueue {
    int front, rear;
    int capacity;
    int[] queue;

    public SimpleQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = 0;
    }

    // Enqueue operation
    void enqueue(int item) {
        if (rear == capacity) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[rear++] = item;
        System.out.println(item + " enqueued to queue");
    }

    // Dequeue operation
    int dequeue() {
        if (front == rear) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int item = queue[front++];
        return item;
    }

    // Display queue elements
    void display() {
        if (front == rear) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
    int frontElement() {
        if (front == rear) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[front];
    }
    int rearElement() {
        if (front == rear) {
            System.out.println("Queue is Empty");
            return -1;
        }
        return queue[rear - 1];
    }

    public static void main(String[] args) {
        SimpleQueue q = new SimpleQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        System.out.println("front element :"+q.frontElement());
        System.out.println("rear element :"+q.rearElement());
        System.out.println(q.dequeue() + " dequeued from queue");
        q.display();
    }
}