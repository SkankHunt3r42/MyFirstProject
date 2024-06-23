package main.javasource.come.magicvet.ServiceLayer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import main.javasource.come.magicvet.entity.ClientEntity;
import main.javasource.come.magicvet.entity.PetEntity;
import main.javasource.come.magicvet.jpaRep.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public class ClientServiceImp implements ClientServiceLayer {

    private final ClientRepo dao;
    private final EntityManager manager;

    @Autowired
    public ClientServiceImp(ClientRepo dao,EntityManager manager) {
        this.dao = dao;
        this.manager = manager;
    }
    @Override
    @Transactional
    public void save(ClientEntity client) {
        dao.save(client);
    }

    @Override
    public List<PetEntity> findPetByClientId(int id) {
        TypedQuery<PetEntity> query = manager.createQuery("from PetEntity where Client.id = :id", PetEntity.class);
        query.setParameter("id",id);
        List<PetEntity> list = query.getResultList();
        return list;

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
