package main.java.come;

import java.util.Scanner;

public class Main {

    static  String passwor = "default";
    static Scanner scanner = new Scanner(System.in);



    public static void main(String[] args) {
        run();
    }
    static  void run() {
        boolean accepted = false;
        for(int a = 0;a<3;a++) {
            System.out.println("Password ");
            String input = scanner.nextLine();

            if(passwor.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Accept denied. Please check your password.");
            }

        }
        System.out.println(accepted ? "Welcome to Magic Vet!" : "Aplication has been blocked.");
    }

}