package main.java.come.magicvet.model;

import main.java.come.magicvet.service.ClientService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class client {

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
