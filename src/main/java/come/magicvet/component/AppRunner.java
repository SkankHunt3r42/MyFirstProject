package main.java.come.magicvet.component;

public class AppRunner {

    private final EntityRegister register = new EntityRegister();

    public void  run() {
        if (Aunteficator.auth()) {
            register.registerClients();
        }
    }
}
