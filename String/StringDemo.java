public class StringDemo {
  public static void main(String[] args) {
    String a = "Hello World";
    System.out.println("Original String: " + a);
     String s = new String("Welcome");
    System.out.println("String using new keyword: " + s);
    System.out.println("The length of a is : "+ a.length());              // length of string
    System.out.println("String is empty :" +a.isEmpty());             // checks if empty
    System.out.println(a.toLowerCase());         // to lowercase
    System.out.println(a.toUpperCase());         // to uppercase
    System.out.println("the charcter at index 0 : "+a.charAt(0));
    System.out.println("the charcter at index 3 : "+a.charAt(3));             // char at index
    System.out.println(a.substring(0, 5));       // returns "Hello"
   System.out.println(a.contains("World"));     // true
   System.out.println(a.equals("Hello"));       // check equality
   System.out.println("The index of o is :"+a.indexOf("o"));          // index of first 'o'
   System.out.println(a.replace("World", "Java")); // replace substring
    String c = "   hello world   ";
    c = c.trim(); // Correct: assign the result
    System.out.println(c);
  }  
}
