package BuilderStrategy;

import lombok.Getter;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Client {
    private final int id;
    private static final AtomicInteger counter = new AtomicInteger(0);
    private final String name;
    private final String email;
    private final int age;
    private final Gender sex;
    public Client(String name, String email, int age, Gender sex){
        this.name = name;
        this.email = email;
        this.age = age;
        this.sex = sex;
        this.id =  counter.incrementAndGet();
    }
}
