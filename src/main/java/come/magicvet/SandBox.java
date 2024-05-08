package main.java.come.magicvet;


import main.java.come.magicvet.model.Dog;
import main.java.come.magicvet.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class SandBox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.M,"2",Pet.HeathStatus.BAD),
                new Dog(Dog.Size.S,"3",Pet.HeathStatus.CRITICAL),
                new Dog(Dog.Size.XL,"12",Pet.HeathStatus.GOOD)
        };
//        Arrays.sort(dogs, new Comparator<Dog>() {
//            @Override
//            public int compare(Dog o1, Dog o2) {
//                return o1.getSize().getValue() - o2.getSize().getValue();
//            }
//        });
        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getHeathStatus().getPriority() - o2.getHeathStatus().getPriority();
            }
        });

        for (Dog dog : dogs){
            System.out.println(dog.getHeathStatus());
        }
    }
}
