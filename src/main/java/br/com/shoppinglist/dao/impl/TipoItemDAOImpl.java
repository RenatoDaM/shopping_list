package main.java.br.com.shoppinglist.dao.impl;


import main.java.br.com.shoppinglist.config.ConnectionFactoryConfig;
import main.java.br.com.shoppinglist.model.TipoItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoItemDAOImpl {

    public void save(TipoItem tipoItem) {
        String sql = "INSERT INTO Tipo_Item(tipo_item_id, tipo_item_desc) VALUES (?, ?)";

        Connection conn = null;
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
        }
    }


    public List<TipoItem> readAll() {
        String sql = "SELECT * FROM Tipo_Item";

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
                TipoItem tipoItem1 = new TipoItem();

                //Recuperar o id
                tipoItem1.setId(rSet.getInt("tipo_item_id"));
                //Recuperar a descricao
                tipoItem1.setDesc(rSet.getString("tipo_item_desc"));

                tipoItemList.add(tipoItem1);
            }

        }catch (Exception e) {
            e.printStackTrace();
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
        return tipoItemList;
    }


    }



