package main.javasource.come.magicvet.component;
import main.javasource.come.magicvet.ServiceLayer.ClientServiceLayer;
import main.javasource.come.magicvet.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Component;

@Component
public class DbOperations {
    private static ClientServiceLayer service;

    @Autowired
    public DbOperations(ClientServiceLayer service) {
        this.service = service;
    }

    public static void findClientById(int id){
        System.out.println("Searching for user with id: "+ id);
        ClientEntity client = service.findClientById(id);
        if(client == null){
            System.out.println("Client with id: "+ id + " not exists");
        } else {
            System.out.println("Client with id: " + id + " \n\t" + client);
        }
    }

}
