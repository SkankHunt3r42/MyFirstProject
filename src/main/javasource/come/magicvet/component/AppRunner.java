package main.javasource.come.magicvet.component;

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
            if(register.chooseOperation()) {
                register.registerClients();
            } else {
                register.chooseDbOperation();
            }
        }

    }
}
