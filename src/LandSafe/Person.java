package LandSafe;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private long ID;
    private boolean alive = true;
    private List<Land> currentProperties;

    public Person(String name, int age, long id) {
        this.name = name;
        this.age = age;
        this.ID = id;
        currentProperties = new ArrayList<>();
    }

    public Person(String name, long id) {
        this(name, 0, id);
    }
    
}
