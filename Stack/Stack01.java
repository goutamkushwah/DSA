import java.util.Stack;

public class Stack01{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek top element
        System.out.println("Top element: " + stack.peek());

        // Pop element
        System.out.println("Popped element: " + stack.pop());

        // Check if stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}