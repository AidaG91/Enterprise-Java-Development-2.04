import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonsList{

    private ArrayList<Person> persons;

    public PersonsList() {
        persons = new ArrayList<>();
    }

    public void addPerson(Person p) {
        persons.add(p);
    }

    public Person findByName(String name) {
        if (name == null || name.split(" ").length != 2) {
            throw new IllegalArgumentException("Formato de nombre inválido. Usa nombre y apellido");
        }

        for (Person person : persons) {
            if (person.getName().equals(name)) {
                return person;
            }
        }

        return null; // Si nadie coincide
    }


    public Person clone(Person original, int newId) {
        return new Person(newId, original.getName(), original.getAge(), original.getOccupation());
   }

   public Person cloneByName(String name) {
        if (name == null || name.split(" ").length != 2) {
            throw new IllegalArgumentException("Formato de nombre inválido. Usa nombre y apellido");
        }

        Person original = findByName(name);
        if (original == null) {
            throw new IllegalArgumentException("No sé encontró ninguna persona con ese nombre");
        }

        int maxId = 0;
        for (Person p : persons) {
            if (p.getId() > maxId) {
                maxId = p.getId();
            }
        }

        int newId = maxId + 1;
        return clone(original, newId);
   }

   public void saveToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("person.txt", true))) {
            writer.write(person.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar a la persona en el archivo:" + e.getMessage());
        }
   }

}
