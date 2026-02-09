package exercise.classExample.user;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ReadOnlyUserImplementation implements UserInterface {
    String name;
    int id;
}
