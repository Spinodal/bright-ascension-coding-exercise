package exercise;

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
 *
 * 5. Incorrect use of exception
 * - replaced Null pointer exception with normal output as this is:
 *   a. not exceptional circumstances, this is a perfectly reasonable outcome for the method.
 *   b. outcome has nothing to do with a "Null pointer".
 * - added missing detail from messages to user
 *
 * 6. StringBuilder for reverse
 * - using existing methods from core java classes and/or libraries can cut down on bugs occurring in the first place
 * - core classes/libraries and popular third party libraries will generally be extensively tested by their owners
 * - Can often improve readability
 *
 * 7. Readability and misc improvements
 * - Remove unnecessary call to stream
 * - improved variable names
 * - more use of printf to cut down on string concatenation
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
    
    System.out.printf("Map size: %d%n", map.size());

    System.out.println("While Loop:");
    // You could use `var` here to improve readability of the iterator, but personally I find that makes it harder to understand what
    // objects are being used, especially during code review outside of an IDE. I'd generally just use them in tests
    Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry<Integer, String> entry = itr.next();
      System.out.printf("Key is %d Value is %s%n", entry.getKey(), entry.getValue());
    }

    System.out.println("Advanced For Loop:");
    for (Map.Entry<Integer, String> entry : map.entrySet()) {
      System.out.printf("Key is %d value is %s%n", entry.getKey(), entry.getValue());
    }

    System.out.println("Stream:");
    map.entrySet().forEach(entry -> {
      System.out.printf("Key is %d value is %s%n", entry.getKey(), entry.getValue());
    });
  }

  public static void palindrome() {
    String original;
    StringBuilder reverse;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter the number or String");
    original = in.nextLine();

    reverse = new StringBuilder(original).reverse();
    
    System.out.printf("reverse is: %s%n", reverse);

    if (original.contentEquals(reverse))
      System.out.println("The number or String is a palindrome");
    else
      System.out.println("The number or String is not a palindrome");
  }
}
