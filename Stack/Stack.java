// Creating stack using array 
public class Stack {
    static final int MAX = 100;
    int top;
    int[] stack = new int[MAX];

    Stack() {
        top = -1;
    }

    // Push operation
    void push(int x) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = x;
            System.out.println(x + " pushed into stack");
        }
    }

    // Pop operation
    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int x = stack[top--];
            return x;
        }
    }

    // Peek operation
    int peek() {
        if (top < 0) {
            System.out.println("Stack is Empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    // Check if stack is empty
    boolean isEmpty() {
        return (top < 0);
    }
    int size() {
        return top + 1;
    }
    void Display() {
        if (top < 0) {
            System.out.println("Stack is Empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.size() + " elements in stack");
        s.Display();
        System.out.println(s.pop() + " popped from stack");
        System.out.println("Top element is " + s.peek());
        System.out.println("Is stack empty? " + s.isEmpty());
       
       }
}