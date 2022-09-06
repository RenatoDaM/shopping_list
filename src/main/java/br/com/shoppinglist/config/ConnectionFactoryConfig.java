package br.com.shoppinglist.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactoryConfig {
    private static final String URL_DB = PropertyConfig.getProperty("url.db.connection");
    private static final String PASS_DB = PropertyConfig.getProperty("pass.db.connection");
    private static final String USER_DB = PropertyConfig.getProperty("user.db.connection");
    private static final String CLASS_DRIVE_CONNECTION = PropertyConfig.getProperty("class.drive.db.connection");

    public static Connection getConnectionDBConfig() {
        try{
            Class.forName(CLASS_DRIVE_CONNECTION);
            return DriverManager.getConnection(URL_DB, USER_DB, PASS_DB);
        }catch (SQLException e){
            System.out.println("Erro ao tentar conectar no banco de dados  -  " + e);
        }catch (ClassNotFoundException e){
            System.out.println("Erro ao importar classe do Drive do banco  -  " + e);
        }
        return null;
    }
}
