package exercise;

import exercise.classExample.user.ReadOnlyUserImplementation;
import exercise.classExample.user.UserImplementation;
import exercise.classExample.user.UserInterface;

import java.util.HashSet;

/**
 * Task:
 *
 * The class example focusses on more general coding standards as well as Java specific standards - the code in the below
 * methods is trying to achieve a specific goal.
 * Applicants should identify issues in the design and implementation of the below code. Answer/think about the following:
 *    What is this class trying to achieve?
 *    What is wrong with how this is currently implemented, and could the goal of this class be achieved in a better way?
 *    General standards/coding issues should also be identified alongside the changes that should be made to correct those issues.
 *
 * Proposed changes should be applied to the class, each change made and the reasoning behind it should be listed below.
 *
 * (Complete below section)
 * Proposed updates & reasoning:
 * 1. Inner classes split
 * - move inner classes into their own files for better structure.
 *
 * 2. Adding unit test
 *
 * 3. Removing unused cached name length
 * - it's good practice to keep code clean from half complete enhancements, especially as there's a chance they will never be needed.
 *
 * 4. Remove unnecessary cleanup
 * - Removing the "reset everything" step as the objects will all drop out of scope as soon as the call to `people.clear()` is called.
 * - Also avoids issues with attempting to change name of immutable user implementations.
 */
public class ClassExample {
  public static String defaultName = "Default name";
  
  public static void main(String[] args) {
    // create my list
    HashSet<UserInterface> people = new HashSet<UserInterface>();
    
    // add some people
    UserInterface myUser = new UserImplementation("Peter");
    people.add(myUser);
    
    myUser = new ReadOnlyUserImplementation("Mark");
    people.add(myUser);
    
    myUser = new UserImplementation(null);
    myUser.setName("Sam");
    people.add(myUser);
    
    // print them out!!
    for (UserInterface person : people) {
      String peopleString = "Person: ";
      peopleString += person.getName();
      
      System.out.println(peopleString);
    }
    
    // now clean up
    people.clear();
  }

}
