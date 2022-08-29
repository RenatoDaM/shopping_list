package main.java.br.com.shoppinglist.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Classe para carregar os properties do projeto
 * Para funcionar deve existir o arquivo application.properties no seguinte caminho:
 * - src/main/resources/application.properties
 * @author Luan
 */
public class PropertyConfig {

    public static String getProperty(String propName) {
        try{
            Properties appProps = new Properties();
            appProps.load(new FileInputStream("src/main/resources/application.properties"));
            return appProps.getProperty(propName);
        }catch (IOException e){
            System.out.println("Erro ao ler o arquivo properties - " + e);
            return null;
        }
    }
}
