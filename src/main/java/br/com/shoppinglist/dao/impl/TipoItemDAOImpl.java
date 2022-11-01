package br.com.shoppinglist.dao.impl;

import br.com.shoppinglist.dao.CrudDAO;
import br.com.shoppinglist.model.TipoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class TipoItemDAOImpl implements CrudDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameter;

    @Override
    public void save(Object o) {
        TipoItem tipoItem = (TipoItem) o;
        String sql = "INSERT INTO tipo_item(tipo_item_id, tipo_item_desc) VALUES (:id, :tipoDesc)";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", tipoItem.getId());
        parameterSource.addValue("tipoDesc", tipoItem.getTipoDesc());
        namedParameter.update(sql, parameterSource);
 /*       Connection conn = null;
        PreparedStatement pStm = null;

        try {
            //Aqui criei uma conexão com o banco de dados, usando o método estático da classe ConnectionDBConfig
            conn = ConnectionFactoryConfig.getConnectionDBConfig();

            //PreparedStatement pra executar uma query
            pStm = conn.prepareStatement(sql);

            //Valores esperados na query
            pStm.setInt(1, tipoItem.getId());
            pStm.setString(2, tipoItem.getDesc());


            pStm.execute();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pStm != null) {
                    pStm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }*/
    }

    @Override
    public List<TipoItem> readAll() {
        String sql = "SELECT tipo_item_id as id, tipo_item_desc as tipoDesc FROM tipo_item";
        List<TipoItem> resultList = namedParameter.query(sql, new BeanPropertyRowMapper(TipoItem.class));
        return resultList;

    }
        /*String sql = "SELECT * FROM Tipo_Item";

        List<TipoItem> tipoItemList = new ArrayList<TipoItem>();

        Connection conn = null;
        PreparedStatement pStm = null;
        //Classe que vai "recuperar" os dados do banco ***SELECT***
        ResultSet rSet = null;

        try {
            conn = ConnectionFactoryConfig.getConnectionDBConfig();
            pStm = conn.prepareStatement(sql);
            rSet = pStm.executeQuery();

            while (rSet.next()) {
                TipoItem tipoItem1 = new TipoItem(rSet.getInt("tipo_item_id"), rSet.getString("tipo_item_desc"));

                tipoItemList.add(tipoItem1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rSet != null) {
                    rSet.close();
                }
                if (pStm != null) {
                    pStm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return tipoItemList;
    }*/

    @Override
    public void update(Object o) {
        TipoItem tipoItem = (TipoItem) o;
        String sql = "UPDATE Tipo_Item SET tipo_item_desc = :tipoDesc" +
                " WHERE tipo_item_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", tipoItem.getId());
        parameterSource.addValue("tipoDesc", tipoItem.getTipoDesc());
        namedParameter.update(sql, parameterSource);


        /*Connection conn = null;
        PreparedStatement pStm = null;

        try {
            //criar conexão com o banco
            conn = ConnectionFactoryConfig.getConnectionDBConfig();
            //executar a query
            pStm = conn.prepareStatement(sql);

            //Adicionar os valores para atualizar
            pStm.setString(1, tipoItem.getDesc());
            pStm.setInt(2, tipoItem.getId());

            //executar a query
            pStm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStm != null) {
                    pStm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

*/
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Tipo_Item WHERE tipo_item_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        namedParameter.update(sql, parameterSource);
    }

/*
        Connection conn = null;
        PreparedStatement pStm = null;

        try {
            conn = ConnectionFactoryConfig.getConnectionDBConfig();
            pStm = conn.prepareStatement(sql);
            pStm.setInt(1, id);
            pStm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStm != null) {
                    pStm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
*/


    @Override
    public TipoItem readById(Integer id) {
        String sql = "SELECT tipo_item_id as id, tipo_item_desc as tipoDesc" + " FROM tipo_item WHERE tipo_item_id = :id";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return namedParameter.queryForObject(sql, parameterSource, new BeanPropertyRowMapper<>(TipoItem.class));

    }
}







/*



        /////////////////////////
        Connection conn = null;
        PreparedStatement pStm = null;
        ResultSet rSet = null;
        String sql = "SELECT * FROM tipo_item WHERE tipo_item_id = ?";

        try {
            conn = ConnectionFactoryConfig.getConnectionDBConfig();
            pStm = conn.prepareStatement(sql);
            pStm.setInt(1, id);
            rSet = pStm.executeQuery();


            while (rSet.next()) {
                TipoItem tipoItem = new TipoItem();

                tipoItem.setId(rSet.getInt("tipo_item_id"));
                //Recuperar a descricao
                tipoItem.setDesc(rSet.getString("tipo_item_desc"));


                return tipoItem;

            }
        }catch (SQLException e){
            System.out.println("Erro ao executar query - SELECT BY ID " + e);
        }finally {
            try {
                if (rSet != null) {
                    rSet.close();
                }
                if (pStm != null) {
                    pStm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;

    }*/




