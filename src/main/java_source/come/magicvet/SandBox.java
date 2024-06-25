package main.java_source.come.magicvet;

import main.java_source.come.magicvet.ServiceLayer.ClientServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SandBox {

    private static ClientServiceLayer layer;
    @Autowired
    public SandBox(ClientServiceLayer layer) {
        this.layer = layer;
    }

    public static void main(String[] args) {


        /*
        SandBox to test application
         */

    }
}