package main.javasource.come.magicvet;

import main.javasource.come.magicvet.component.AppRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;
@SpringBootApplication
public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        AppRunner runner = context.getBean(AppRunner.class);
        runner.run();

    }
}