package exercise.classExample.user;

public class ReadOnlyUserImplementation implements UserInterface {
    private final String name;
    private final int id;

    public ReadOnlyUserImplementation(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }
}
