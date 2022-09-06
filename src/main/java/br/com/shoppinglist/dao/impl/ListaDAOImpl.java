package br.com.shoppinglist.dao.impl;

import br.com.shoppinglist.config.ConnectionFactoryConfig;
import br.com.shoppinglist.dao.CrudDAO;
import br.com.shoppinglist.model.Lista;

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
        String sql = "INSERT INTO lista (lista_desc) VALUES (?)";
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setString(1, lista.getDesc());
                statement.execute();
                System.out.println("Lista --- " + lista.getDesc() + " --- criada com sucesso ");
        }catch (SQLException e){
            System.out.println("Erro ao executar query - INSERT " + e);
        }finally {
            closeConnections(statement, connection);
        }
    }

    @Override
    public Lista readById(Integer id) {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "SELECT * FROM lista WHERE lista_id = ?";
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    Lista lista = new Lista(resultSet.getInt("lista_id"), resultSet.getString("lista_desc"),
                            resultSet.getDouble("lista_valor_total"), resultSet.getInt("lista_qtd_item"));
                    return lista;
                }
        }catch (SQLException e){
            System.out.println("Erro ao executar query - SELECT BY ID " + e);
        }finally {
            closeConnections(statement, connection);
        }
        return null;
    }

    @Override
    public List<Lista> readAll() {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "SELECT * FROM lista";
        try{
            List<Lista> listas = new ArrayList<>();
            if(connection != null)
                statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()){
                    Lista lista = new Lista(resultSet.getInt("lista_id"), resultSet.getString("lista_desc"),
                            resultSet.getDouble("lista_valor_total"), resultSet.getInt("lista_qtd_item"));
                    listas.add(lista);
                }
                return listas;
        }catch (SQLException e){
            System.out.println("Erro ao executar query - SELECT ALL " + e);
        }finally {
            closeConnections(statement, connection);
        }
        return null;
    }

    @Override
    public void update(Object o) {
        Lista lista = (Lista) o;
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "UPDATE lista SET lista_desc = ?, lista_valor_total = ?, lista_qtd_item = ? " +
                "WHERE lista_id = ? ";
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setString(1, lista.getDesc());
                statement.setDouble(2, lista.getValorTotal());
                statement.setInt(3, lista.getQtdItens());
                statement.setInt(4, lista.getId());
                statement.execute();
                System.out.println("Lista --- " + lista.getDesc() + " --- atualizada com sucesso ");
        }catch (SQLException e){
            System.out.println("Erro ao executar query - UPDATE " + e);
        }finally {
            closeConnections(statement, connection);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "DELETE FROM lista WHERE lista_id = ?";
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                System.out.println("Lista de id " + id + " deletada com sucesso ");
        }catch (SQLException e){
            System.out.println("Erro ao executar query - DELETE " + e);
        }finally {
            closeConnections(statement, connection);
        }
    }

    private void closeConnections(PreparedStatement statement, Connection connection){
        try{
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }catch (SQLException e){
            System.out.println("Erro ao tentar fechar conexões de banco " + e);
        }
    }
}
