package main.java.come.magicvet.model;

public class Pet {

    private String Type;
    private String sex;
    private String age;
    private String name;
    private String owner;

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
}
