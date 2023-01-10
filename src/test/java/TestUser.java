import BuilderStrategy.Gender;
import BuilderStrategy.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestUser {
    @Test
    public void testUser(){
        User user = User.builder().name("Sviatoslav Lushnei")
                        .weight(100).height(100)
                        .age(13).gender(Gender.MALE)
                        .email("sviatoslav.lushnei@ucu.edu.ua")
                        .build();
        Assertions.assertEquals(user.getName(), "Sviatoslav Lushnei" );
        Assertions.assertEquals(user.getAge(), 13 );
        Assertions.assertEquals(user.getGender(), Gender.MALE );
    }
}
