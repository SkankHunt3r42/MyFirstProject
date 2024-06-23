package main.javasource.come.magicvet.component;

import main.javasource.come.magicvet.Main;
import main.javasource.come.magicvet.ServiceLayer.ClientServiceLayer;
import main.javasource.come.magicvet.entity.ClientEntity;
import main.javasource.come.magicvet.entity.PetEntity;
import main.javasource.come.magicvet.model.Client;
import main.javasource.come.magicvet.model.Pet;
import main.javasource.come.magicvet.service.ClientService;
import main.javasource.come.magicvet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.stream.Collectors;
@Component
public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    private final Scanner scanner = new Scanner(System.in);
    private ClientEntity clientEntity = new ClientEntity();
    private List<PetEntity>petList;
    private ClientServiceLayer layer;

    @Autowired
    public EntityRegister(ClientServiceLayer layer) {
        this.layer = layer;
    }

    public boolean chooseOperation(){
        System.out.print("Choose operation: \n" +
                "Do you want to create new user ?: (Yes/No) " );
        String operation = scanner.nextLine();
        return operation.equals("Yes");
    }

    private Client addClient(){
        ClientEntity clientEntity1 = new ClientEntity();
        Client client = clientService.registerNewClient();
        if(client != null && client.isUserDataValid() && clientService.confirmation()){
            registerPets(client);
            clientEntity1.addAll(client);
            clientEntity = clientEntity1;
        }
        System.out.println("Shut downing ");
        return client;
    }

    public void registerClients(){
        List<Client> clients = new ArrayList<>();

        String message = "Do you want to register more clients? (yes/no): ";
        do {
            Client client = addClient();
            if (client != null){
                clients.add(client);
                saveCLient(petList);

//                clientEntity.add(petEntity1);//FIX
//                layer.save(clientEntity);
//                System.out.println(clientEntity.getPets());
            }

        }while (verifyRepeating(message));

        Map<Client.Location,List<Client>> clientsByLocation = clients.stream()
                .collect(Collectors.groupingBy(Client::getLocation));


        printClients(clientsByLocation);
    }

    private void saveCLient(List<PetEntity> petList) {
        for (PetEntity pet : petList){
            clientEntity.add(pet);
        }
        layer.save(clientEntity);

    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for(Map.Entry<Client.Location,List<Client>> map : clientsByLocation.entrySet()){
            String content = "\nLocation: " + map.getKey()
                    +"\nClients " + map.getValue().size() + ":"
                    +"\n\t"  + map.getValue();
            System.out.println(content);
        }
    }

    private void registerPets(Client client){
        String message = "Do you want to register more pets? (yes/no): ";
        do {
            addPet(client);
            System.out.println(client);
        }while (verifyRepeating(message));

    }

    private void addPet(Client client) {
        System.out.println("Adding a new pet.");
        PetEntity petEntity = new PetEntity();
        List<PetEntity> list = new ArrayList<>();
        Pet pet = petService.registerNewPet();
        client.addPet(pet);
        pet.setOwner(client.getFirstName() + " " + client.getLastName());
        System.out.println("Pet has been added. ");
        petEntity.addAll(pet);
        list.add(petEntity);
        petList = list;
    }
    private boolean verifyRepeating(String message){

        System.out.print(message);
        String answer = Main.scanner.nextLine();
        if("yes".equals(answer)){
            return true;
        } else if("no".equals(answer)){
            return false;
        } else {
            System.out.println("Incorrect answer.Please try again.");
            return verifyRepeating(message);
        }

    }

    public void chooseDbOperation() {
        System.out.print("Choose operation\n" +
                "FindClientById <----- (FNC)\n" +
                "FindCoursesByClientId <-----(FCBCI) ");
        String operation = scanner.nextLine();
        if(operation.equals("FNC")){
            DbOperations.findClientById(2);
        }
    }
}
