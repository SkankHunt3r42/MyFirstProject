package main.java_source.come.magicvet.component;
import main.java_source.come.magicvet.Main;
import main.java_source.come.magicvet.ServiceLayer.ClientServiceLayer;
import main.java_source.come.magicvet.entity.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Component;

@Component
public final class DbOperations {
    private static ClientServiceLayer service;

    private DbOperations() {
    }

    @Autowired
    public DbOperations(ClientServiceLayer service) {
        this.service = service;
    }

    public static void findClientById(){
        System.out.print("Input client id: ");
        int id  = Main.scanner.nextInt();
        System.out.println("Searching for user with id: "+ id);
        ClientEntity client = service.findClientById(id);
        if(client == null){
            System.out.println("Client with id: "+ id + " not exists");
        } else {
            System.out.println("Client with id: " + id + " \n\t" + client);
        }
    }
    public static void findPetsById(){
        System.out.print("Input client id: ");
        int id  = Main.scanner.nextInt();
        System.out.println("Searching for Client with id: " + id);
        ClientEntity client = service.findClientById(id);
        if(client == null){
            System.out.println("Client with id: "+ id + " not exists");
        }else {
            System.out.println("Client with id: " + id + " was successful find! ");
            System.out.println("Client pets: " + client.getPets());
        }


    }
    public static void chooseDbOperation() {
            System.out.print("Choose operation\n" +
                    "FindClientById <----- (FNC)\n" +
                    "FindPetsByClientId <-----(FPBCI) ");
            String operation = Main.scanner.nextLine();
            switch (operation) {
                case "FNC" -> DbOperations.findClientById();
                case "FPBCI" -> DbOperations.findPetsById();

            }

    }

}
