package main.java_source.come.magicvet.entity;

import jakarta.persistence.*;
import lombok.Data;
import main.java_source.come.magicvet.model.Pet;


@Data
@Entity
@Table(name = "Pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String Type;
    String Sex;
    String Age;
    String Name;
    String Owner;

    public PetEntity() {
    }

    public PetEntity(String age, String type, String sex, String name, String owner) {
        Age = age;
        Type = type;
        Sex = sex;
        Name = name;
        Owner = owner;
    }
    public void addAll(Pet pet){
        this.Type = pet.getType();
        this.Sex = pet.getSex();
        this.Age = pet.getAge();
        this.Name = pet.getName();
        this.Owner = pet.getOwner();
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;


    @Override
    public String toString() {
        return "\n\tPet type - " + Type
                +"\n\tSex - " + Sex
                +"\n\tAge - " + Age
                +"\n\tName - " + Name
                +"\n\tOwner - " + Owner;
    }
}
