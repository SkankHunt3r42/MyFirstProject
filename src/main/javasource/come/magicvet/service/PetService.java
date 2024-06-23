package main.javasource.come.magicvet.service;

import main.javasource.come.magicvet.Main;
import main.javasource.come.magicvet.model.Cat;

import main.javasource.come.magicvet.model.Dog;
import main.javasource.come.magicvet.model.Pet;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.stream.Stream;

public class PetService {

    private  static final String DOG_TYPE = "dog";
    private  static final String CAT_TYPE = "cat";

    public Pet registerNewPet() {
        Pet pet;
        System.out.println("Type (dog / cat): ");

        String type = Main.scanner.nextLine();


        if(DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type - " + type);
            pet = buildPet(type);
        }
        return pet;
    }


    private Pet buildPet(String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);


        System.out.print("Age: ");
        pet.setAge(Main.scanner.nextLine());

        System.out.print("Name: ");
        pet.setName(Main.scanner.nextLine());

        System.out.print("Sex (male / female): ");
        pet.setSex(Main.scanner.nextLine());

        if(type.equals(DOG_TYPE)){
            System.out.println("Size(XS / S / M / L / XL): ");
          
            String size = Main.scanner.nextLine().toUpperCase();

            ((Dog) pet).setSize(Dog.Size.fromString(size));
        }
        return pet;
    }
}
