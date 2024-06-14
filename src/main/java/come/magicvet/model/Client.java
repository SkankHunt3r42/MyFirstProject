package main.java.come.magicvet.model;

import come.magicvet.service.ClientService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {


    @Override

    public String toString() {
        return "\u001B[34m Client Data - [ "
                + "\n\tClient Name -  " + firstName
                + "\n\tClient secondName - " + lastName
                + "\n\tClient email - " + email
                + "\u001B[31m \n\t\tClient Pet - " + pet
                + "\u001B[0m"
                +"\u001B[34m \n\tRegistration time - " + registerDate.format(FORMATTER)
                + "\n]" + "\u001B[0m";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, pet);
    }

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private static String firstName;

    private static String lastName;
    private String email;
    private Pet pet;
    private final LocalDateTime registerDate = LocalDateTime.now();


    public void setFristName(String fristName) {
        this.firstName = fristName;
    }

    public String getFristName() {
        return firstName;
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
        Matcher matcher = pattern.matcher(firstName);
        Matcher matcher1 = pattern.matcher(lastName);

        return matcher.matches() && matcher1.matches();
    }

}