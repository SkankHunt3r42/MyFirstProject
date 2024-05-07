package main.java.come.magicvet;

import main.java.come.magicvet.comporator.DogAgeComparator;
import main.java.come.magicvet.comporator.DogSizeComparator;
import main.java.come.magicvet.model.Dog;
import main.java.come.magicvet.model.Pet;
import org.w3c.dom.Node;

import java.util.Arrays;

public class SandBox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.XS,"2"),
                new Dog(Dog.M,"3"),
                new Dog(Dog.XL,"12")
        };




        Arrays.sort(dogs,new DogAgeComparator());

        for (Dog dog : dogs){
            System.out.println(dog.getAge());
        }
    }
}
