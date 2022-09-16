package br.com.shoppinglist.dao.impl;

import br.com.shoppinglist.config.ConnectionFactoryConfig;
import br.com.shoppinglist.dao.CrudDAO;
import br.com.shoppinglist.model.Lista;
import br.com.shoppinglist.model.ListaItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaItemDAOImpl implements CrudDAO {

    @Override
    public void save(Object o) {
        ListaItem listaItem = (ListaItem) o;
        String sql = "INSERT INTO lista_item (lista_lista_id, item_item_id, qtd_item, valor_total) VALUES (?, ?, ?, ?)";
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setInt(1, listaItem.getListaId());
                statement.setInt(2, listaItem.getItemId());
                statement.setInt(3, listaItem.getQtdItem());
                statement.setDouble(4, listaItem.getValorTotal());
                statement.execute();
                System.out.println("Item  --- " + listaItem.getItemId() + " --- criada com sucesso na Lista " + listaItem.getListaId());
        }catch (SQLException e){
            System.out.println("Erro ao executar query - INSERT " + e);
        }finally {
            closeConnections(statement, connection);
        }
    }

    @Override
    public ListaItem readById(Integer id) {
        /* No momento essa função não é necessária para tabela lista_item */
        return null;
    }

    @Override
    public List<ListaItem> readAll() {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "SELECT * FROM lista_item";
        try{
            if(connection != null) {
                statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                List<ListaItem> listaItems = new ArrayList<>();
                while (resultSet.next()) {
                    ListaItem listaItem = new ListaItem(
                            resultSet.getInt("lista_lista_id"),
                            resultSet.getInt("item_item_id"),
                            resultSet.getInt("qtd_item"),
                            resultSet.getDouble("valor_total"));
                    listaItems.add(listaItem);
                }
                return listaItems;
            }
        }catch (SQLException e){
            System.out.println("Erro ao executar query - SELECT BY ID " + e);
        }finally {
            closeConnections(statement, connection);
        }
        return null;
    }


    @Override
    public void update(Object o) {
        ListaItem listaItem = (ListaItem) o;
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "UPDATE lista_item SET qtd_item = ?, valor_total = ? " +
                "WHERE lista_lista_id = ? AND item_item_id = ?";
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setInt(1, listaItem.getQtdItem());
                statement.setDouble(2, listaItem.getValorTotal());
                statement.setInt(3, listaItem.getListaId());
                statement.setInt(4, listaItem.getItemId());
                statement.execute();
                System.out.println("Registro  --- " + listaItem.getListaId() + "-" + listaItem.getQtdItem() + " --- atualizado com sucesso ");
        }catch (SQLException e){
            System.out.println("Erro ao executar query - UPDATE " + e);
        }finally {
            closeConnections(statement, connection);
        }
    }

    @Override
    public void delete(Integer idItem) {
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "DELETE FROM lista_item WHERE item_item_id = ?";
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setInt(1, idItem);
                statement.execute();
                System.out.println("Item de id " + idItem + " deletado da tabela lista_item");
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
