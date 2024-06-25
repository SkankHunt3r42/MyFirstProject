package main.java_source.come.magicvet.component;

import main.java_source.come.magicvet.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppRunner {

    private final EntityRegister register;

    @Autowired
    public AppRunner(EntityRegister register) {
        this.register = register;
    }
    public void  run() {
        if (Aunteficator.auth()) {
            if(chooseOperation()) {
                register.registerClients();
            } else {
                DbOperations.chooseDbOperation();
            }
        }

    }
    public boolean chooseOperation(){
        System.out.print("Choose operation: \n" +
                "Do you want to create new user ?: (Yes/No) " );
        String operation = Main.scanner.nextLine();
        return operation.toLowerCase().equals("yes");
    }
}
