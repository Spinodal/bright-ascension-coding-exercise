package exercise;

import exercise.classExample.user.ReadOnlyUserImplementation;
import exercise.classExample.user.UserImplementation;
import exercise.classExample.user.UserInterface;

import java.util.ArrayList;
import java.util.List;

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
 * - it's good practice to keep code clean from half complete enhancements, especially as there's a chance they will
 *   never be needed.
 *
 * 4. Remove unnecessary cleanup
 * - Removing the "reset everything" step as the objects will all drop out of scope as soon as the call to
 *   `people.clear()` is called.
 * - Also avoids issues with attempting to change name of immutable user implementations.
 *
 * 5. Fixing bugs and issues
 * - Fixing bug with name initialisation - setting local variable instance of instance variable
 * - Swapping set to a list - allows for different people with the same name be created
 * - Removing default name - having a default doesn't make sense for this use case. It also breaks the immutability of
 *   the readonly implementation
 * - Remove setName from interface - avoids the need to return an exception for the readonly implementation when trying
 *   to call setName. Also reduces the potential for users with a null name from being created.
 * - Add default constructor to UserImplementation to avoid creating a use with an explicit `null` name
 *
 */
public class ClassExample {

  public static void main(String[] args) {
    // create my list
    List<UserInterface> people = new ArrayList<>();
    
    // add some people
    UserInterface myUser = new UserImplementation("Peter");
    people.add(myUser);
    
    myUser = new ReadOnlyUserImplementation("Mark");
    people.add(myUser);
    
    UserImplementation myEditableUser = new UserImplementation();
    myEditableUser.setName("Sam");
    people.add(myEditableUser);
    
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
