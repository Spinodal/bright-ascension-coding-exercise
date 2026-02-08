package exercise.classExample.user;

import exercise.ClassExample;

public class UserImplementation implements UserInterface {
    private String theName = ClassExample.defaultName;
    private int cachedNameLength;

    public UserImplementation(String theName) {
        theName = theName;

        cachedNameLength = theName.length();
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
