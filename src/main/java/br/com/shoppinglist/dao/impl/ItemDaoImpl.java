package br.com.shoppinglist.dao.impl;

import br.com.shoppinglist.config.ConnectionFactoryConfig;
import br.com.shoppinglist.dao.CrudDAO;
import br.com.shoppinglist.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements CrudDAO {
    @Override
    public void save(Object o) {
        Item item = (Item) o;
        String sql = "INSERT INTO item (item_id, item_desc, item_preco, Tipo_Item_tipo_item_id)";
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        try {
            if (connection != null){
                statement = connection.prepareStatement(sql);
                statement.setInt(1, item.getId());
                statement.setString(2, item.getDesc());
                statement.setDouble(3, item.getPreco());
                statement.setInt(4,item.getTipoItemId());
                statement.execute();
                System.out.println("Item --- " + item.getDesc() + " --- criado com sucesso ");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar query - INSERT " + e);
        } finally {
            closeConnections(statement, connection);
        }
    }

    @Override
    public List<Item> readAll() {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "SELECT * FROM item";
        try {
            List<Item> items = new ArrayList<>();
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while(resultSet.next()) {
                    items.add(new Item(resultSet.getInt("item_id"), resultSet.getString("item_desc"), resultSet.getDouble("item_preco"), resultSet.getInt("Tipo_Item_tipo_item_id")));
                }
                return items;

            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar query - SELECT ALL " + e);
        } finally {
            closeConnections(statement, connection);
        }
        return null;
    }

    @Override
    public Item readById(Integer id) {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "SELECT * FROM item WHERE item_id = ?";
        try {
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    return new Item(resultSet.getInt("item_id"), resultSet.getString("item_desc"), resultSet.getDouble("item_preco"), resultSet.getInt("Tipo_Item_tipo_item_id"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar query - SELECT BY ID " + e);
        } finally {
            closeConnections(statement, connection);
        }
        return null;
    }

    @Override
    public void update(Object o) {
        Item item = (Item) o;
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "UPDATE item SET item_desc = ?, item_preco = ?, Tipo_Item_tipo_item_id = ? " +
                "WHERE item_id = ?";
        try {
            if(connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setString(1, item.getDesc());
                statement.setDouble(2, item.getPreco());
                statement.setInt(3, item.getTipoItemId());
                statement.setInt(4, item.getId());
                statement.execute();
                System.out.println("Item --- " + item.getDesc() + " --- atualizado com sucesso ");
            }
        }catch (SQLException e) {
            System.out.println("Erro ao executar query - UPDATE " + e);
        } finally {
            closeConnections(statement, connection);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "DELETE FROM item WHERE item_id = ?";
        try {
            if (connection != null) {
                statement = connection.prepareStatement(sql);
                statement.setInt(1, id);
                statement.execute();
                System.out.println("Item de id " + id + " deletada com sucesso");
            }
        }catch (SQLException e) {
            System.out.println("Erro ao executar query - DELETE " + e);
        } finally {
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
