package main.java_source.come.magicvet.ServiceLayer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.java_source.come.magicvet.entity.ClientEntity;
import main.java_source.come.magicvet.entity.PetEntity;
import main.java_source.come.magicvet.jpaRep.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class ClientServiceImp implements ClientServiceLayer {

    private final ClientRepo dao;

//    private final EntityManager manager; <-- commented for future update

    @Autowired
    public ClientServiceImp(ClientRepo dao,EntityManager manager) {
        this.dao = dao;
//        this.manager = manager;
    }
    @Override
    public void save(ClientEntity client) {
        dao.save(client);
    }
    @Override
    public ClientEntity findClientById(int id) {
        Optional<ClientEntity> optional = dao.findById(id);
        ClientEntity client = null;
        if(optional.isPresent()){
            client = optional.get();
        }
        return client;
    }
}
