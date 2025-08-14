public class concatenationString {
    public static void main(String[] args) {
    // Using + Operator
       String a = "Hello";
        String b = "World";
        String result = a + " " + b;  // Hello World
        System.out.println(result);
     //2. Using concat() Method
       String result1 = a.concat(" ").concat(b);  // Hello World
        System.out.println(result1);
     //3. Using StringBuilder (Best in loops)
      StringBuilder sb = new StringBuilder();
     sb.append("Hello").append(" ").append("World");
      System.out.println(sb.toString());
     
    }
}
