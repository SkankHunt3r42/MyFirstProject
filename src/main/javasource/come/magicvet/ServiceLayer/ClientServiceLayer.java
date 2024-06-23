package main.javasource.come.magicvet.ServiceLayer;

import main.javasource.come.magicvet.entity.ClientEntity;
import main.javasource.come.magicvet.entity.PetEntity;

import java.util.List;

public interface ClientServiceLayer {

    void save(ClientEntity client);
    List<PetEntity> findPetByClientId(int id);
    ClientEntity findClientById(int id);
}
