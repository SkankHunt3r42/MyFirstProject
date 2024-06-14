package main.java.come.magicvet.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class Pet {

    private String Type;
    private String sex;
    private String age;
    private String name;
    private String owner;


    @Override
    public String toString() {
        return "{"
                +"\n\tType - " + Type
                + "\n\tSex - " + sex
                +"\n\tAge - " + age
                +"\n\tName - " + name
                +"\n\tOwner - " + owner
                +"\n\t}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(Type, pet.Type) && Objects.equals(sex, pet.sex) && Objects.equals(age, pet.age) && Objects.equals(name, pet.name) && Objects.equals(owner, pet.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Type, sex, age, name, owner);
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }


    public enum HeathStatus{

        GOOD(0),
        NORMAL(1),
        BAD(2),
        CRITICAL(3)
        ;
        private final int priority;

        HeathStatus(int priority) {
            this.priority = priority;
        }

        public int getPriority() {
            return priority;
        }

    }

}