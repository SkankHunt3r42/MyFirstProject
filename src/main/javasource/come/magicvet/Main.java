package main.javasource.come.magicvet;

import main.javasource.come.magicvet.component.AppRunner;

import java.util.Scanner;

public class Main {


    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AppRunner runner = new AppRunner();
        runner.run();
    }
}