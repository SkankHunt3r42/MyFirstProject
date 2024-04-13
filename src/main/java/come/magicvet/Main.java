package main.java.come.magicvet;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static  String password = "default";
    static Scanner scanner = new Scanner(System.in);

    static  String  EMAIL_PATERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";



    public static void main(String[] args) {
        run();
    }
    static  void run() {
        if(auth()) {
            registerNewClient();
        }

    }


    static boolean auth() {
        boolean accepted = false;
        for(int a = 0;a<3;a++) {
            System.out.print("Password ");
            String input = scanner.nextLine();

            if(password.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Accept denied. Please check your password.");
            }

        }
        System.out.println(accepted ? "Welcome to Magic Vet!" : "Aplication has been blocked.");
        return accepted;
    }

    static void registerNewClient() {
        System.out.println("Please provide client details. ");
        System.out.print("Email ");
        String email = scanner.nextLine();

        if (isEmailValid(email)) {
            client client = buidClient(email);
            System.out.println("New client: " + client.fristName + " " + client.lastName + " (" + client.email + ")");
        } else {
            System.out.println("Provided email is invalid.");
        }
    }

    static client buidClient(String email) {
        client client = new client();
        client.email = email;

        System.out.println("First name: ");
        client.fristName = scanner.nextLine();

        System.out.println("Last name: ");
        client.lastName = scanner.nextLine();

        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }


}