package main.java.come.magicvet.component;

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
                System.out.println("Adding a new pet.");

                Pet pet = petService.registerNewPet();
                if(pet != null) {
                    cli.setPet(pet);
                    pet.setOwner(cli.getFristName() + " " + cli.getLastName());
                    System.out.println("Pet has been added. ");
                }
                    System.out.println(cli);
            } else {
                System.out.println("Shut downing ");
            }
        }
    }


}
