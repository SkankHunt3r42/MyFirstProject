package main.javasource.come.magicvet;

import main.javasource.come.magicvet.ServiceLayer.ClientServiceLayer;
import main.javasource.come.magicvet.entity.ClientEntity;
import main.javasource.come.magicvet.entity.PetEntity;
import main.javasource.come.magicvet.model.Dog;
import main.javasource.come.magicvet.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SandBox {

    private static ClientServiceLayer layer;
    @Autowired
    public SandBox(ClientServiceLayer layer) {
        this.layer = layer;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        ClientEntity entity = new ClientEntity("fdfdf","DKDKDKD","DKDKDKD");
        PetEntity pet = new PetEntity();
        Pet pet1 = new Dog();
        pet.addAll(pet1);
        entity.add(pet);
        layer.save(entity);
        System.out.println(entity.getPets());

    }
}