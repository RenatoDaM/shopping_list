package br.com.shoppinglist.service;

import br.com.shoppinglist.dao.CrudDAO;
import br.com.shoppinglist.dao.impl.ListaDAOImpl;
import br.com.shoppinglist.model.Lista;

import java.util.List;

public class ListaDeCompraService {

    private final CrudDAO crudDAO;

    public ListaDeCompraService() {
        this.crudDAO = new ListaDAOImpl();
    }

    public void criarListaDeCompras(Lista lista){
        boolean listaUnica = true;
        List<Lista> listas = buscarListasDeCompras();
        if(!listas.isEmpty()){
            for (Lista l : listas){
                if(l.getDesc().equalsIgnoreCase(lista.getDesc())){
                    System.out.println(" +-- Já existe uma lista com esse nome --+ ");
                    listaUnica = false;
                }
            }
        }
        if(listaUnica) crudDAO.save(lista);
    }

    public List<Lista> buscarListasDeCompras(){
        List<Lista> listas = crudDAO.readAll();
        return listas;
    }
}
