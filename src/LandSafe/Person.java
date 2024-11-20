package LandSafe;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String id;
    private int age;
    private boolean alive;
    private List<Land> propertiesOwned;

    public Person(String name, String id, int age, boolean alive) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.alive = alive;
        this.propertiesOwned = new ArrayList<>();
    }

    public void addProperty(Land land) {
        if (propertiesOwned.contains(land)) return;
        this.propertiesOwned.add(land);
    }

    public void removeProperty(Land land) {
        if (!propertiesOwned.contains(land)) return;
        this.propertiesOwned.remove(land);
    }

    public String getName() {
        return name;
    }
    
    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public boolean isAlive() {
        return alive;
    }

    public List<Land> getPropertiesOwned() {
        return propertiesOwned;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }   
    public void setPropertiesOwned(List<Land> propertiesOwned) {
        this.propertiesOwned = propertiesOwned;
    }
    /*
     * This method returns a string representation of the Person object
     * @return a string representation of the Person object
     * Also, it returns the name, id, age, and alive status of the person
     */
    public String toString() {
        return "Person [name=" + name + ", id=" + id + ", age=" + age + ", alive=" + alive + "]";
    }
    /*
     * This method checks if two Person objects are equal
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }
}
