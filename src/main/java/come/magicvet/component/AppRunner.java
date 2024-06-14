package main.java.come.magicvet.component;

import main.java.come.magicvet.Main;
import main.java.come.magicvet.model.Pet;
import main.java.come.magicvet.model.Client;
import come.magicvet.service.ClientService;
import main.java.come.magicvet.service.PetService;
public class AppRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();


    public void  run() {
        if (Aunteficator.auth()) {
            Client cli  = clientService.registerNewClient();

            if( cli != null && cli.isUserDataValid() && clientService.confirmation()) {
                registerPets(cli);
                    System.out.println(cli);
            } else {
                System.out.println("Shut downing ");
            }
        }
    }
    private void registerPets(Client client){
        boolean continueAddPets = true;
        while (continueAddPets){
            addPet(client);

            System.out.print("Do you want to add more pets ? (yes/no): ");
            String answer = Main.scanner.nextLine();

            if("no".equals(answer)){
                continueAddPets = false;
            }
        }
    }
    private void addPet(Client client){
        System.out.println("Adding a new pet.");

        Pet pet = petService.registerNewPet();
        if(pet != null) {
            client.addPets(pet);
            pet.setOwner(client.getFristName() + " " + client.getLastName());
            System.out.println("Pet has been added. ");
        }
    }


}
