package main.java.come.magicvet.service;

import main.java.come.magicvet.Main;
import main.java.come.magicvet.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static  final String  EMAIL_PATERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String REGEX = "[a-zA-Z-']{3,}";

    public Client registerNewClient() {
        Client cli = null;
        System.out.println("Please provide client details. ");
        System.out.print("Email ");
        String email = Main.scanner.nextLine();

        if (isEmailValid(email)) {
            cli = buidClient(email);
            if(cli.isUserDataValid()) {
                System.out.println("New client: " + cli.getFirstName() + " " +
                        cli.getLastName() + " " +
                        "(" + cli.getEmail() + ")");
            } else {
                System.out.println("User data is invalid,check your input data.");
            }
        } else {
            System.out.println("Provided email is invalid.");
            return registerNewClient();
        }
        return cli;
    }


    private static Client buidClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        System.out.println("First name: ");
        client.setFirstName(Main.scanner.nextLine());

        System.out.println("Last name: ");
        client.setLastName(Main.scanner.nextLine());

        System.out.println("Location: ");
        Client.Location location;
        String locationInput = Main.scanner.nextLine().toUpperCase();
        try {
            location = Client.Location.valueOf(locationInput);
        } catch (IllegalArgumentException exc){
            location = Client.Location.UNKNOWN;
            System.out.println("Unable to parse value: " + locationInput + " .Using default value - " + Client.Location.UNKNOWN);
        }
        client.setLocation(location);
        return client;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }
    public boolean confirmation () {
        boolean confirmed = false;
        System.out.print("Do you want to add pet now? - (yes/no): ");
        String confirm = Main.scanner.nextLine();
        if(confirm.equals("yes")) {
            confirmed = true;
        }
        return confirmed;
    }

}
