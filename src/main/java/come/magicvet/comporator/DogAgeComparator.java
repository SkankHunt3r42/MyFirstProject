package main.java.come.magicvet.comporator;

import main.java.come.magicvet.model.Dog;

import java.util.Comparator;

public class DogAgeComparator implements Comparator<Dog> {

    @Override
    public int compare(Dog dog1, Dog dog2) {
        return Integer.parseInt(dog1.getAge()) - Integer.parseInt(dog2.getAge());
    }

}
