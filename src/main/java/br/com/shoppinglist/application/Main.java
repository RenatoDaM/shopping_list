package br.com.shoppinglist.application;

import br.com.shoppinglist.dao.impl.TipoItemDAOImpl;
import br.com.shoppinglist.model.TipoItem;

public class Main {
    public static void main(String[] args) {
        TipoItemDAOImpl tipoItemDAO = new TipoItemDAOImpl();
        TipoItem tipoItem = new TipoItem();


        System.out.println(tipoItemDAO.readAll());

    }
}
