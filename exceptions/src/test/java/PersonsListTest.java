import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonsListTest {
    @Test
    public void testFindByNameValid() {
        PersonsList list = new PersonsList();
        Person p = new Person(1, "Juan Cuesta", 44, "Médico");
        list.addPerson(p);

        Person result = list.findByName("Juan Cuesta");
        assertEquals(p, result);
    }

    @Test
    public void testFindByNameInvalid() {
        PersonsList list = new PersonsList();
        assertThrows(IllegalArgumentException.class, () -> {
            list.findByName("Juancho");
        });
    }

    @Test
    public void testClonePerson() {
        PersonsList list = new PersonsList();
        Person original = new Person(5, "Pato Lucas", 88, "Pato");

        Person cloned = list.clone(original, 10);

        assertNotEquals(original.getId(), cloned.getId());
        assertEquals(original.getName(), cloned.getName());
        assertEquals(original.getAge(), cloned.getAge());
        assertEquals(original.getOccupation(), cloned.getOccupation());
    }
}
