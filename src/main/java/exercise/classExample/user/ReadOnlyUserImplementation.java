package exercise.classExample.user;

import exercise.ClassExample;

public class ReadOnlyUserImplementation implements UserInterface {
    public String theName = ClassExample.defaultName;

    public ReadOnlyUserImplementation(String theName) {
        theName = theName;
    }

    @Override
    public void setName(String theName) {
        throw new RuntimeException("Implementation is invariant");
    }

    @Override
    public String getName() {
        return theName;
    }
}
