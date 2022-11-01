package br.com.shoppinglist.dao.impl;

import br.com.shoppinglist.dao.CrudDAO;
import br.com.shoppinglist.model.ListaItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class ListaItemDAOImpl implements CrudDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameter;
    @Override
    public void save(Object o) {
        ListaItem listaItem = (ListaItem) o;
        String sql = "INSERT INTO lista_item(lista_lista_id, item_item_id, qtd_item, valor_total) VALUES (:listaId, :itemId, :qtdItem, :valorTotal)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("listaId", listaItem.getListaId());
        parameterSource.addValue("itemId", listaItem.getItemId());
        parameterSource.addValue("qtdItem", listaItem.getQtdItem());
        parameterSource.addValue("valorTotal", listaItem.getValorTotal());
        namedParameter.update(sql, parameterSource);
    }
/*        ListaItem listaItem = (ListaItem) o;
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
    }*/

    @Override
    public ListaItem readById(Integer id) {
 /*No momento essa função não é necessária para tabela lista_item */

        return null;
    }

    @Override
    public List<ListaItem> readAll() {
        String sql = "SELECT lista_lista_id as listaId, item_item_id as itemId, qtd_item as qtdItem," +
                " valor_total as valorTotal FROM lista_item";
        List<ListaItem> resultList = namedParameter.query(sql, new BeanPropertyRowMapper(ListaItem.class));
        return resultList;
    }
/*
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
*/


    @Override
    public void update(Object o) {
        //Não esta respondendo direito, peço pra atualizar por exemplo 2, 6. ele atualiza o 2, 2 e não o 2, 6.
        ListaItem listaItem = (ListaItem) o;
        String sql = "UPDATE lista_item SET qtd_item = :qtdItem, valor_total = :valorTotal WHERE lista_lista_id = :listaId " +
                "AND item_item_id = :itemId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("qtdItem", listaItem.getQtdItem());
        parameterSource.addValue("valorTotal", listaItem.getValorTotal());
        parameterSource.addValue("listaId", listaItem.getListaId());
        parameterSource.addValue("itemId", listaItem.getListaId());
        namedParameter.update(sql, parameterSource);
    }
/*        ListaItem listaItem = (ListaItem) o;
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
    }*/

    @Override
    public void delete(Integer idItem) {
        String sql = "DELETE FROM lista_item WHERE item_item_id = :itemId";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("itemId", idItem);
        namedParameter.update(sql, parameterSource);
    }
/*        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
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
    }*/

 /*   private void closeConnections(PreparedStatement statement, Connection connection){
        try{
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }catch (SQLException e){
            System.out.println("Erro ao tentar fechar conexões de banco " + e);
        }
    }*/
}
