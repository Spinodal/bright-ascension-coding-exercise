package exercise.classExample.user;

public class ReadOnlyUserImplementation implements UserInterface {
    public final String name;

    public ReadOnlyUserImplementation(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
