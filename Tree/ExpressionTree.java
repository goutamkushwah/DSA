import java.util.*;

class Node {
    String value; // Operand (e.g., "3") or operator (e.g., "+")
    Node left, right;

    Node(String value) {
        this.value = value;
        left = right = null;
    }
}

public class ExpressionTree {
    
    // Build expression tree from postfix expression
    private Node buildTree(String[] postfix) {
        if (postfix == null || postfix.length == 0) {
            throw new IllegalArgumentException("Empty postfix expression");
        }

        Stack<Node> stack = new Stack<>();
        for (String token : postfix) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalStateException("Invalid postfix expression: insufficient operands");
                }
                Node right = stack.pop();
                Node left = stack.pop();
                Node node = new Node(token);
                node.left = left;
                node.right = right;
                stack.push(node);
            } else {
                stack.push(new Node(token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Invalid postfix expression: too many operands");
        }
        return stack.pop();
    }

    // Check if a token is an operator
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    // Get precedence of operators
    private int getPrecedence(String op) {
        switch (op) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0; // For non-operators (operands)
        }
    }

    // Convert infix expression to postfix
    private String[] infixToPostfix(String infix) {
        if (infix == null || infix.trim().isEmpty()) {
            throw new IllegalArgumentException("Empty infix expression");
        }

        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        infix = infix.replaceAll("\\s", ""); // Remove spaces

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            // Build multi-digit numbers
            if (Character.isDigit(c)) {
                number.append(c);
                continue;
            } else if (number.length() > 0) {
                output.add(number.toString());
                number.setLength(0);
            }

            // Handle operators and parentheses
            if (c == '(') {
                stack.push(String.valueOf(c));
            } else if (c == ')') {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    output.add(stack.pop());
                }
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
                stack.pop(); // Remove '('
            } else if (isOperator(String.valueOf(c))) {
                String op = String.valueOf(c);
                while (!stack.isEmpty() && !stack.peek().equals("(") &&
                       getPrecedence(stack.peek()) >= getPrecedence(op)) {
                    output.add(stack.pop());
                }
                stack.push(op);
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        // Add last number if exists
        if (number.length() > 0) {
            output.add(number.toString());
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            String top = stack.pop();
            if (top.equals("(")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            output.add(top);
        }

        return output.toArray(new String[0]);
    }

    // Evaluate the expression tree
    private double evaluateTree(Node node) {
        if (node == null) {
            throw new IllegalStateException("Invalid expression tree");
        }

        // If leaf node (operand), return its value
        if (!isOperator(node.value)) {
            try {
                return Double.parseDouble(node.value);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid operand: " + node.value);
            }
        }

        // Evaluate left and right subtrees
        double leftValue = evaluateTree(node.left);
        double rightValue = evaluateTree(node.right);

        // Perform operation
        switch (node.value) {
            case "+":
                return leftValue + rightValue;
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            case "/":
                if (rightValue == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return leftValue / rightValue;
            default:
                throw new IllegalStateException("Invalid operator: " + node.value);
        }
    }

    // Public method to process infix expression and return result
    public double evaluate(String infix) {
        // Convert infix to postfix
        String[] postfix = infixToPostfix(infix);
        // Build expression tree
        Node root = buildTree(postfix);
        // Evaluate tree and return result
        return evaluateTree(root);
    }

    // Main method for testing
    public static void main(String[] args) {
        ExpressionTree et = new ExpressionTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an infix expression (e.g., (3+4)*2/7): ");
        String infix = scanner.nextLine();

        try {
            double result = et.evaluate(infix);
            System.out.printf("Result: %.2f%n", result);
        } catch (IllegalArgumentException | IllegalStateException | ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}