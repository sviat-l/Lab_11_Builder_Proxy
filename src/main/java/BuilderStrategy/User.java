package BuilderStrategy;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class User {
    private String name;
    private String email;
    private int age;
    private Gender gender;
    private double height;
    private double weight;
}
