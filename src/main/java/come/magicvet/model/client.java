package main.java.come.magicvet.model;

public class client {

    private String fristName;

    private String lastName;
    private String email;
    private Pet pet;

    public void setFristName(String fristName) {
        this.fristName = fristName;
    }

    public String getFristName() {
        return fristName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
