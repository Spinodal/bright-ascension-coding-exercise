package exercise.classExample.user;

public class UserImplementation implements UserInterface {
    private String name = "";

    public UserImplementation(String name) {
        this.name = name;
    }

    public UserImplementation() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
