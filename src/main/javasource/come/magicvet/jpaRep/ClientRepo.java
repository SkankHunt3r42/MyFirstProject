package main.javasource.come.magicvet.jpaRep;

import main.javasource.come.magicvet.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientEntity,Integer> {
}
