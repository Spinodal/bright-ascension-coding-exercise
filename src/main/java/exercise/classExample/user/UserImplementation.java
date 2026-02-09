package exercise.classExample.user;

public class UserImplementation implements UserInterface {
    private String name = "";
    private int id;

    public UserImplementation(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public UserImplementation() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id){
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
