package come.magicvet.service;

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
                System.out.println("New client: " + cli.getFristName() + " " +
                        cli.getLastName() + " " +
                        "(" + cli.getEmail() + ")");
            } else {
                System.out.println("User data is invalid,check your input data.");
                registerNewClient();
            }
        } else {
            System.out.println("Provided email is invalid.");
             registerNewClient();
        }
        return cli;
    }


    private static Client buidClient(String email) {
        Client cli = new Client();
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
