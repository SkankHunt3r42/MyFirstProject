package main.java_source.come.magicvet.ServiceLayer;

import main.java_source.come.magicvet.entity.ClientEntity;
import main.java_source.come.magicvet.entity.PetEntity;

import java.util.List;

public interface ClientServiceLayer {

    void save(ClientEntity client);
    ClientEntity findClientById(int id);
}
