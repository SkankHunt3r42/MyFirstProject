package main.javasource.come.magicvet.entity;

import jakarta.persistence.*;
import lombok.Data;
import main.javasource.come.magicvet.model.Client;


import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Client")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String first_name;
    String last_name;
    String email;

    public ClientEntity() {
    }

    public ClientEntity(String first_name, String last_name, String email) {
        this.first_name = first_name;
        this.email = email;
        this.last_name = last_name;
    }
    @OneToMany(mappedBy = "clientEntity",cascade = CascadeType.ALL)
    private List<PetEntity> pets;


    public void addAll(Client client){
        first_name = client.getFirstName();
        last_name = client.getLastName();
        email = client.getEmail();
    }
    public void add(PetEntity pet){
        if(pets == null){
            pets = new ArrayList<>();
        }
        pets.add(pet);
        pet.setClientEntity(this);
    }

    @Override
    public String toString() {
        return "Client id - " + id
                +"\n\tFirst name - " + first_name
                +"\n\tLast name - " + last_name
                +"\n\tEmail - " + email;
    }
}
