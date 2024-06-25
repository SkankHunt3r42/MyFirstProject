package main.java_source.come.magicvet.jpaRep;

import main.java_source.come.magicvet.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<ClientEntity,Integer> {
}
