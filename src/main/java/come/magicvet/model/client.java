package main.java.come.magicvet.model;

import main.java.come.magicvet.service.ClientService;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class client {


    @Override

    public String toString() {
        return "\u001B[34m" +"Client Data - [ "
                + "\n\tClient Name -  " + fristName
                + "\n\tClient secondName - " + lastName
                + "\n\tClient email - " + email
                + "\n\t\tClient Pet - " + pet
                + "\n]" + "\u001B[0m";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        client client = (client) o;
        return Objects.equals(fristName, client.fristName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fristName, lastName, email, pet);
    }


    private static String fristName;

    private static String lastName;
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
    public  boolean isUserDataValid() {
        Pattern pattern = Pattern.compile(ClientService.REGEX);
        Matcher matcher = pattern.matcher(fristName);
        Matcher matcher1 = pattern.matcher(lastName);

        return matcher.matches() && matcher1.matches();
    }

}
