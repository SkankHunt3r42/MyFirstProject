package main.java.come.magicvet.component;

import main.java.come.magicvet.Main;
import main.java.come.magicvet.model.Client;
import main.java.come.magicvet.model.Pet;
import main.java.come.magicvet.service.ClientService;
import main.java.come.magicvet.service.PetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    private Client addClient(){
        Client client = clientService.registerNewClient();

        if( client != null && client.isUserDataValid() && clientService.confirmation()) {
            registerPets(client);
            System.out.println(client);
        }
        System.out.println("Shut downing ");
        return client;
    }

    public void registerClients(){
        List<Client> clients = new ArrayList<>();

        String message = "Do you want to register more clients? (yes/no)";
        do {
            Client client = addClient();
            if (client != null){
                clients.add(client);
            }
        }while (verifyRepeating(message));

        Map<Client.Location,List<Client>> clientsByLocation = groupClients(clients);

    }

    private Map<Client.Location, List<Client>> groupClients(List<Client> clients) {
        List<Client> fromKyiv = new ArrayList<>();
        List<Client> fromLviv = new ArrayList<>();
        List<Client> fromOdessa = new ArrayList<>();
        List<Client> unknownLocation = new ArrayList<>();
        for(Client client : clients){
            switch (client.getLocation()){
                case KYIV -> fromKyiv.add(client);
                case ODESSA -> fromOdessa.add(client);
                case LVIV -> fromLviv.add(client);
                case UNKNOWN ->  unknownLocation.add(client);

            }
        }
        Map<Client.Location,List<Client>> clientsByLocation = new HashMap<>();
        clientsByLocation.put(Client.Location.KYIV,fromKyiv);
        clientsByLocation.put(Client.Location.LVIV,fromLviv);
        clientsByLocation.put(Client.Location.ODESSA,fromOdessa);
        clientsByLocation.put(Client.Location.UNKNOWN,unknownLocation);

        printClients(clientsByLocation);
        return clientsByLocation;
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
        String message = "Do you want to register more clients? (yes/no)";
        do {
            addPet(client);

        }while (verifyRepeating(message));

    }

    private void addPet(Client client){
        System.out.println("Adding a new pet.");

        Pet pet = petService.registerNewPet();
        if(pet != null) {
            client.addPet(pet);
            pet.setOwner(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added. ");
        }
    }
    private boolean verifyRepeating(String message){
        System.out.println(message);
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

}
