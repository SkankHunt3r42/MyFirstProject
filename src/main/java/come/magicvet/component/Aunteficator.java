package main.java.come.magicvet.component;

import main.java.come.magicvet.Main;

public class Aunteficator {

    public static boolean auth() {
        boolean accepted = false;
        for(int a = 0;a<3;a++) {
            System.out.print("Password ");
            String input = Main.scanner.nextLine();

            String password = "d";
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


}
