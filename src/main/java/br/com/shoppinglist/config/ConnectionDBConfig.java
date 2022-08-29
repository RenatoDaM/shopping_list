package main.java.br.com.shoppinglist.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDBConfig {
    private static String urlDb = PropertyConfig.getProperty("url.db.connection");
    private static String passDb = PropertyConfig.getProperty("pass.db.connection");
    private static String userDb = PropertyConfig.getProperty("user.db.connection");

    public static Connection getConnectionDBConfig() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(urlDb,userDb,passDb);
        }catch (SQLException e){
            System.out.println("Erro ao tentar conectar no banco de dados  -  " + e);
        }catch (ClassNotFoundException e){
            System.out.println("Erro ao importar classe do Drive do banco  -  " + e);
        }
        return null;
    }
}
