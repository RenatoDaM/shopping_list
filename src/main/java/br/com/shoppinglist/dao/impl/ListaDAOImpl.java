package main.java.br.com.shoppinglist.dao.impl;

import main.java.br.com.shoppinglist.config.ConnectionFactoryConfig;
import main.java.br.com.shoppinglist.dao.CrudDAO;
import main.java.br.com.shoppinglist.model.Lista;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaDAOImpl implements CrudDAO {

    @Override
    public void save(Object o) {
        Lista lista = (Lista) o;
        String sql = "INSERT INTO lista (lista_desc, lista_valor_total) VALUES (?, ?)";
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(sql);
            statement.setString(1, lista.getDesc());
            statement.setDouble(2, lista.getValorTotal());
            statement.execute();
            System.out.println("Lista --- " + lista.getDesc() + " --- salva com sucesso ");
        }catch (SQLException e){
            System.out.println("Erro ao executar query - INSERT " + e);
        }finally {
            closeConnections(statement, connection);
        }
    }

    @Override
    public List<Lista> readList() {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "SELECT * FROM lista";
        try{
            List<Lista> listas = new ArrayList<>();
            statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Lista lista = new Lista(resultSet.getInt("lista_id"),
                        resultSet.getString("lista_desc"),
                        resultSet.getDouble("lista_valor_total"));
                listas.add(lista);
            }
            return listas;
        }catch (SQLException e){
            System.out.println("Erro ao executar query - INSERT " + e);
        }finally {
            closeConnections(statement, connection);
        }
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    private void closeConnections(PreparedStatement statement, Connection connection){
        try{
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("Erro ao tentar fechar conexões de banco " + e);
        }
    }
}
