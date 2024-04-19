package main.java.come.magicvet.service;

import main.java.come.magicvet.Main;
import main.java.come.magicvet.model.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static  String  EMAIL_PATERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public client registerNewClient() {
        client cli = null;
        System.out.println("Please provide client details. ");
        System.out.print("Email ");
        String email = Main.scanner.nextLine();

        if (isEmailValid(email)) {
            cli = buidClient(email);
            System.out.println("New client: " + cli.getFristName() + " " +
                    cli.getLastName()+ " " +
                    "(" + cli.getEmail() + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
        return cli;
    }


    private static client buidClient(String email) {
        client cli = new client();
        cli.setEmail(email);

        System.out.println("First name: ");
        cli.setFristName(Main.scanner.nextLine());

        System.out.println("Last name: ");
        cli.setLastName(Main.scanner.nextLine());

        return cli;
    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

}
