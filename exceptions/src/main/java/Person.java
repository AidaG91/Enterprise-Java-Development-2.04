public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        } else {
            this.age = age;
        }
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Person)) return false;

        Person other = (Person) obj;
        if (this.name.equals(other.name)
                && this.occupation.equals(other.occupation)
                && this.age == other.age) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Edad: " + age + ", Ocupación: " + occupation;
    }

}
