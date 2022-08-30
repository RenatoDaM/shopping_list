package main.java.br.com.shoppinglist.application;

import main.java.br.com.shoppinglist.config.ConnectionFactoryConfig;
import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        System.out.println(" ------ Teste para conexão de banco ------ ");
        System.out.println(ConnectionFactoryConfig.getConnectionDBConfig());
    }
}
