package main.java_source.come.magicvet.model;

import lombok.Data;
import main.java_source.come.magicvet.service.ClientService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class Client {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    private String firstName;

    private String lastName;
    private String email;
    private List<Pet> pets = new ArrayList<>();
    private final LocalDateTime registerDate = LocalDateTime.now();
    private Location location;

    public  boolean isUserDataValid() {
        Pattern pattern = Pattern.compile(ClientService.REGEX);
        Matcher matcher = pattern.matcher(firstName);
        Matcher matcher1 = pattern.matcher(lastName);

        return matcher.matches() && matcher1.matches();
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, pets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName)
                && Objects.equals(lastName, client.lastName)
                && Objects.equals(email, client.email)
                && Objects.equals(pets, client.pets);
    }

    @Override
    public String toString() {
        return "\u001B[34m Client Data - [ "
                + "\n\tClient Name -  " + firstName
                + "\n\tClient secondName - " + lastName
                + "\n\tClient email - " + email
                +"\n\tLocation - " + location
                + "\u001B[31m \n\t\tClient Pet - " + pets
                + "\u001B[0m"
                +"\u001B[34m \n\tRegistration time - " + registerDate.format(FORMATTER)
                + "\n]" + "\u001B[0m";
    }


    public enum Location{
        KYIV,LVIV,ODESSA,UNKNOWN
    }
}