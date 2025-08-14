public class DoubleEndeded {

    int[] arr;
    int front, rear, size, capacity;

    public DoubleEndeded(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

    // Insert at front
    void insertFront(int key) {
        if (isFull()) {
            System.out.println("Deque Overflow");
            return;
        }
        if (front == -1) { // Empty deque
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = capacity - 1;
        } else {
            front = front - 1;
        }
        arr[front] = key;
        size++;
        System.out.println(key + " inserted at front");
    }

    // Insert at rear
    void insertRear(int key) {
        if (isFull()) {
            System.out.println("Deque Overflow");
            return;
        }
        if (front == -1) { // Empty deque
            front = 0;
            rear = 0;
        } else if (rear == capacity - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        arr[rear] = key;
        size++;
        System.out.println(key + " inserted at rear");
    }

    // Delete from front
    int deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque Underflow");
            return -1;
        }
        int val = arr[front];
        if (front == rear) { // Only one element
            front = -1;
            rear = -1;
        } else if (front == capacity - 1) {
            front = 0;
        } else {
            front = front + 1;
        }
        size--;
        return val;
    }

    // Delete from rear
    int deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque Underflow");
            return -1;
        }
        int val = arr[rear];
        if (front == rear) { // Only one element
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = capacity - 1;
        } else {
            rear = rear - 1;
        }
        size--;
        return val;
    }

    boolean isFull() {
        return ((front == 0 && rear == capacity - 1) || (front == rear + 1));
    }

    boolean isEmpty() {
        return (front == -1);
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Deque is Empty");
            return;
        }
        System.out.print("Deque elements: ");
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoubleEndeded dq = new DoubleEndeded(5);
        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.insertFront(2);
        dq.display();
        System.out.println(dq.deleteRear() + " deleted from rear");
        System.out.println(dq.deleteFront() + " deleted from front");
        dq.display();
    }
}
