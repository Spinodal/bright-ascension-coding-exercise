package exercise.classExample.user;

import exercise.ClassExample;

public class UserImplementation implements UserInterface {
    private String theName = ClassExample.defaultName;

    public UserImplementation(String theName) {
        theName = theName;
    }

    @Override
    public void setName(String theNewName) {
        theName = theName;
    }

    @Override
    public String getName() {
        return theName;
    }
}
