public class String01 {
 
    public static void main(String[] args) {
        String s = "  Hello Java World  ";
        System.out.println("Original: '" + s + "'");
        System.out.println("Length: " + s.length());
        System.out.println("Trimmed: '" + s.trim() + "'");
        System.out.println("Uppercase: " + s.toUpperCase());
        System.out.println("Lowercase: " + s.toLowerCase());
        System.out.println("Substring (7 to 11): " + s.substring(7, 11));
        System.out.println("Replace 'a' with '@': " + s.replace('a', '@'));
        System.out.println("Index of 'J': " + s.indexOf('J'));
        System.out.println("Starts with '  He': " + s.startsWith("  He"));
        System.out.println("Ends with 'ld  ': " + s.endsWith("ld  "));
        System.out.println("Split by space:");
        
        String[] words = s.trim().split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
