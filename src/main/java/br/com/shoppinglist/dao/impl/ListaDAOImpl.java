package br.com.shoppinglist.dao.impl;

import br.com.shoppinglist.dao.CrudDAO;
import br.com.shoppinglist.model.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class ListaDAOImpl implements CrudDAO {
    @Autowired
    private NamedParameterJdbcTemplate namedParameter;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Object o) {
        Lista lista = (Lista) o;
        String sql = "INSERT INTO lista(lista_id, lista_desc, lista_valor_total, lista_qtd_item) VALUES (:id, :listDesc, :valorTotal, :qtdItens)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", lista.getId());
        parameterSource.addValue("listDesc", lista.getListDesc());
        parameterSource.addValue("valorTotal", lista.getValorTotal());
        parameterSource.addValue("qtdItens", lista.getQtdItens());
        namedParameter.update(sql, parameterSource);
    }
/*        Lista lista = (Lista) o;
        String sql = "INSERT INTO lista (lista_desc) VALUES (?)";
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setString(1, lista.getListDesc());
                statement.execute();
                System.out.println("Lista --- " + lista.getListDesc() + " --- criada com sucesso ");
        }catch (SQLException e){
            System.out.println("Erro ao executar query - INSERT " + e);
        }finally {
            closeConnections(statement, connection);
        }
    }*/

    @Override
    public Lista readById(Integer id) {
        String sql = "SELECT lista_id as id, lista_desc as listDesc, lista_valor_total as valorTotal," +
                " lista_qtd_item as qtdItens FROM " +
                "lista WHERE lista_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return namedParameter.queryForObject(sql, parameterSource, new BeanPropertyRowMapper<Lista>(Lista.class));

    }
/*        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
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
        return null;*/


    @Override
    public List<Lista> readAll() {
        String sql = "SELECT lista_id as id, lista_desc as listDesc, lista_valor_total as valorTotal, lista_qtd_item as qtdItens" +
                " FROM lista";
        List<Lista> resultList = namedParameter.query(sql, new BeanPropertyRowMapper(Lista.class));
        return resultList;
    }

    @Override
    public void update(Object o) {
        Lista lista = (Lista) o;
        String sql = "UPDATE lista SET lista_desc = :listDesc, lista_valor_total = :valorTotal, lista_qtd_item = :qtdItens " +
                "WHERE lista_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", lista.getId());
        parameterSource.addValue("valorTotal", lista.getValorTotal());
        parameterSource.addValue("qtdItens", lista.getQtdItens());
        parameterSource.addValue("listDesc", lista.getListDesc());
        namedParameter.update(sql, parameterSource);
/*        Lista lista = (Lista) o;
        Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
        PreparedStatement statement = null;
        String sql = "UPDATE lista SET lista_desc = ?, lista_valor_total = ?, lista_qtd_item = ? " +
                "WHERE lista_id = ? ";
        try{
            if(connection != null)
                statement = connection.prepareStatement(sql);
                statement.setString(1, lista.getListDesc());
                statement.setDouble(2, lista.getValorTotal());
                statement.setInt(3, lista.getQtdItens());
                statement.setInt(4, lista.getId());
                statement.execute();
                System.out.println("Lista --- " + lista.getListDesc() + " --- atualizada com sucesso ");
        }catch (SQLException e){
            System.out.println("Erro ao executar query - UPDATE " + e);
        }finally {
            closeConnections(statement, connection);
        }*/
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM lista WHERE lista_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        namedParameter.update(sql, parameterSource);


        /*Connection connection = ConnectionFactoryConfig.getConnectionDBConfig();
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
        }*/
    }

/*    private void closeConnections(PreparedStatement statement, Connection connection){
        try{
            if(statement != null) statement.close();
            if(connection != null) connection.close();
        }catch (SQLException e){
            System.out.println("Erro ao tentar fechar conexões de banco " + e);
        }
    }*/
}
