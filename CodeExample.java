import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Task:
 * This task focusses on Java standards and conventions through a handful of methods designed to achieve a specific goal.
 * Applicants should identify any issues in the below code and consider what the methods are trying to achieve and how they
 * are currently implemented. What is done poorly or incorrectly? What changes should be made to correct that behaviour?
 *
 * Proposed changes should be applied to the class, each change made and the reasoning behind it should be listed below.
 *
 * (Complete below section)
 * Proposed updates & reasoning:
 * 1. Generics
 * - Ensure generics are used throughout
 * - Simplify initialisation
 * - Remove unnecessary casting
 * Allows better type safety and reduces chances of errors with explicit casting.
 *
 * 2. Use interfaces where possible
 * - allows you to modify which implementation is being used without large refactors.
 *
 * 3. Palindrome bug
 * - bug with palindrome method resulted in first letter being missed
 * - fixed typo
 *
 * 4. StringBuilder efficiency
 * - Use StringBuilder to avoid string concatenation overhead
 * - use printf and remove unnecessary variable
 */

public class CodeExample {
  public static void main(String[] args) {
    hashMapOutput();
    
    palindrome();
  }

  public static void hashMapOutput() {
    Map <Integer,String> map = new HashMap<>();
    map.put(2, "Two");
    map.put(25, "Twenty Five");
    map.put(12, "Twelve");
    
    System.out.println(map.size());

    System.out.println("While Loop:");
    Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry<Integer, String> me = itr.next();
      System.out.println("Key is " + me.getKey() + " Value is " + me.getValue());
    }

    System.out.println("Advanced For Loop:");
    for (Map.Entry<Integer, String> me2 : map.entrySet()) {
      System.out.println("Key is: " + me2.getKey() + " Value is: " + me2.getValue());
    }

    System.out.println("Stream:");
    map.entrySet().stream().forEach(me3 -> {
      System.out.println("Key is: " + me3.getKey() + " Value is: " + me3.getValue());
    });
  }

  public static void palindrome() {
    String original;
    StringBuilder reverse;
    Scanner in = new Scanner(System.in);
    int length;
    
    System.out.println("Enter the number or String");
    original = in.nextLine();
    length = original.length();
    reverse = new StringBuilder(length);
    
    for (int i = length - 1; i >= 0; i--) {
      reverse.append(original.charAt(i));
    }
    
    System.out.printf("reverse is: %s\n", reverse);

    if (original.contentEquals(reverse))
      System.out.println("The number is palindrome");
    else
      throw new NullPointerException("The number is not a palindrome");
  }
}
