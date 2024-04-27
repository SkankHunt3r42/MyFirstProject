package main.java.come.magicvet.service;

import main.java.come.magicvet.Main;
import main.java.come.magicvet.model.Dog;
import main.java.come.magicvet.model.Pet;

public class PetService {

    private  static final String DOG_TYPE = "dog";

    public Pet registerNewPet() {
        Pet pet = new Pet();
        System.out.println("Type (dog / cat / other): ");

        String type = Main.scanner.nextLine();

        pet.setType(type);

        if(DOG_TYPE.equals(type)) {
            pet = BuildDog();
        } else {
            pet = buildPet(type);
        }
        return pet;
    }

    private Pet BuildDog() {
       Pet pet = buildPet(DOG_TYPE);
        Dog dog = petToDog(pet);

        System.out.println("Size (xS / s / M / L / xxL)");
        dog.setSize(Main.scanner.nextLine());

        return dog;
    }

    private Dog petToDog(Pet pet) {
        Dog dog = new Dog();
        dog.setAge(pet.getAge());
        dog.setName(pet.getName());
        dog.setType(pet.getType());
        dog.setSex(pet.getSex());
        return dog;
    }

    private Pet buildPet(String type) {
        Pet pet = new Pet();
        pet.setType(type);

        System.out.println("Age: ");
        pet.setAge(Main.scanner.nextLine());

        System.out.println("Name: ");
        pet.setName(Main.scanner.nextLine());

        System.out.println("Sex (male / female): ");
        pet.setSex(Main.scanner.nextLine());


        return pet;
    }
}
