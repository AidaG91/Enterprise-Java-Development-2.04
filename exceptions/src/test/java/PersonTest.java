import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testSetAgeValid() {
        Person p = new Person(1, "Lola Perez", 23, "Aparejadora");
        p.setAge(25);
        assertEquals(25, p.getAge());
    }

    @Test
    public void testSetAgeInvalid() {
        Person p = new Person(2, "Juan Palomo", 32, "Arqueólogo");
        assertThrows(IllegalArgumentException.class, () -> {
            p.setAge(-5);
        });
    }
}
