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
 * <p>
 * Proposed changes should be applied to the class, each change made and the reasoning behind it should be listed below.
 * <p>
 * (Complete below section)
 * Proposed updates & reasoning:
 * 1. Generics
 * - Ensure generics are used throughout
 * - Simplify initialisation
 * - Remove unnecessary casting
 * Allows better type safety and reduces chances of errors with explicit casting.
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/c31976e3d407e7af834ee44417dd418340dd8485
 * <p>
 * 2. Use interfaces where possible
 * - allows you to modify which implementation is being used without large refactors.
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/c31976e3d407e7af834ee44417dd418340dd8485
 * <p>
 * 3. Palindrome bug
 * - bug with palindrome method resulted in first letter being missed
 * - fixed typo
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/a8fb64e387a59abc4696963c8546100a1d4cbfeb
 * <p>
 * 4. StringBuilder efficiency
 * - Use StringBuilder to avoid string concatenation overhead
 * - use printf and remove unnecessary variable
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/28b76104dfcdb88c47f22fd6fe9e09856b2f9871
 * <p>
 * 5. Incorrect use of exception
 * - replaced Null pointer exception with normal output as this is:
 * a. not exceptional circumstances, this is a perfectly reasonable outcome for the method.
 * b. outcome has nothing to do with a "Null pointer".
 * - added missing detail from messages to user
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/d66bda8bc95ad9c27759aa6acc5d478249469757
 * <p>
 * 6. StringBuilder for reverse
 * - using existing methods from core java classes and/or libraries can cut down on bugs occurring in the first place
 * - core classes/libraries and popular third party libraries will generally be extensively tested by their owners
 * - Can often improve readability
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/dea26af15878aed1986354906ef05525795eb463
 * <p>
 * 7. Readability and misc improvements
 * - Remove unnecessary call to stream
 * - improved variable names
 * - more use of printf to cut down on string concatenation
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/33a6f8ee00754c93a8b885a45a5a16b78b27abe5
 */

public class CodeExample {
    public static void main(String[] args) {
        hashMapOutput();

        palindrome();
    }

    public static void hashMapOutput() {
        Map<Integer, String> map = new HashMap<>();
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
