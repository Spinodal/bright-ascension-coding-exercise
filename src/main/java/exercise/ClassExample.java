package exercise;

import exercise.classExample.user.Counter;
import exercise.classExample.user.ReadOnlyUserImplementation;
import exercise.classExample.user.UserImplementation;
import exercise.classExample.user.UserInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Task:
 * <p>
 * The class example focusses on more general coding standards as well as Java specific standards - the code in the below
 * methods is trying to achieve a specific goal.
 * Applicants should identify issues in the design and implementation of the below code. Answer/think about the following:
 * What is this class trying to achieve?
 * What is wrong with how this is currently implemented, and could the goal of this class be achieved in a better way?
 * General standards/coding issues should also be identified alongside the changes that should be made to correct those issues.
 * <p>
 * Proposed changes should be applied to the class, each change made and the reasoning behind it should be listed below.
 * <p>
 * (Complete below section)
 * Proposed updates & reasoning:
 * 1. Inner classes split
 * - move inner classes into their own files for better structure.
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/f70f1a3d496e4832ab3007bee240a222a0ea862c
 * <p>
 * 2. Adding unit test
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/f70f1a3d496e4832ab3007bee240a222a0ea862c
 * <p>
 * 3. Removing unused cached name length
 * - it's good practice to keep code clean from half complete enhancements, especially as there's a chance they will
 * never be needed.
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/fb3bf39bc3af7d85ac80d1c427e5b0212cf875a1
 * <p>
 * 4. Remove unnecessary cleanup
 * - Removing the "reset everything" step as the objects will all drop out of scope as soon as the call to
 * `people.clear()` is called.
 * - Also avoids issues with attempting to change name of immutable user implementations.
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/fb3bf39bc3af7d85ac80d1c427e5b0212cf875a1
 * <p>
 * 5. Fixing bugs and issues
 * - Fixing bug with name initialisation - setting local variable instance of instance variable
 * - Swapping set to a list - allows for different people with the same name be created, and allows for
 * - Removing default name - having a default doesn't make sense for this use case. It also breaks the immutability of
 * the readonly implementation
 * - Remove setName from interface - avoids the need to return an exception for the readonly implementation when trying
 * to call setName. Also reduces the potential for users with a null name from being created.
 * - Add default constructor to UserImplementation to avoid creating a use with an explicit `null` name
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/37efb99121c2e696163c40b0a2bd554f5a2dfd65
 * <p>
 * 6. Other improvements
 * - adding ID to allow for unique identification of users. Setting IDs will ideally be done by a database
 * - printf to reduce string concatenation
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/c0d4e256cdfec45fdf697f8e9990cfb90a2334b6
 * <p>
 * 7. Lombok
 * Migrate pojos to using lombok to reduce boilerplate and include other useful features like automatic hashcode +
 * equals methods. Also allows easy additions like builders for alternative ways of constructing objects. In my opinion
 * this would be a better approach than allowing a user to be created and setting the name separately in the use cases
 * below.
 * https://github.com/Spinodal/bright-ascension-coding-exercise/pull/1/changes/3b456030018b4ef5a991e2930dd56bbe5a41bf4a
 */
public class ClassExample {

    public static void main(String[] args) {
        // create my list
        List<UserInterface> people = new ArrayList<>();
        Counter counter = new Counter();
        // add some people
        UserInterface myUser = new UserImplementation("Peter", counter.nextId());
        people.add(myUser);

        myUser = new ReadOnlyUserImplementation("Mark", counter.nextId());
        people.add(myUser);

        UserImplementation myEditableUser = new UserImplementation();
        myEditableUser.setName("Sam");
        myEditableUser.setId(counter.nextId());
        people.add(myEditableUser);

        myUser = UserImplementation.builder()
                .name("Mike")
                .id(counter.nextId())
                .build();
        people.add(myUser);

        // print them out!!
        for (UserInterface person : people) {
            System.out.printf("Person: %s, ID: %d%n", person.getName(), person.getId());
        }

        // now clean up
        people.clear();
    }

}
