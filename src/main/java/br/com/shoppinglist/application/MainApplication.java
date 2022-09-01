package main.java.br.com.shoppinglist.application;

import main.java.br.com.shoppinglist.config.ConnectionDBConfig;
import main.java.br.com.shoppinglist.dao.TipoItemDAO;
import main.java.br.com.shoppinglist.model.TipoItem;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        System.out.println(" ------ Teste para conexão de banco ------ ");
        System.out.println(ConnectionDBConfig.getConnectionDBConfig());

        TipoItemDAO tipoItemDao = new TipoItemDAO();

        // TipoItem testeDoRenato = new TipoItem();
        //  testeDoRenato.setId(49);
        //  testeDoRenato.setDesconto("50");


        //  tipoItemDao.save(testeDoRenato);

        // Testando listagem
       // for (TipoItem tipo : tipoItemDao.readAll()) {
            //     System.out.println("Tipo item: " + tipo.getDesc());
        tipoItemDao.readAll();
        }
    }


