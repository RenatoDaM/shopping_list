package br.com.shoppinglist.service;

import br.com.shoppinglist.dao.impl.ListaDAOImpl;
import br.com.shoppinglist.model.Lista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListaDeCompraService {

    @Autowired
    private ListaDAOImpl listaDAO;

    public void criarListaDeCompras(Lista lista){
        boolean listaUnica = true;

        List<Lista> listas = buscarListasDeCompras();

        if(!listas.isEmpty())
            for (Lista l : listas)
                if(l.getListDesc().equalsIgnoreCase(lista.getListDesc()))
                    System.out.println(" +-- Já existe uma lista com esse nome --+ ");
        listaUnica = false;
        if(listaUnica) listaDAO.save(lista);
    }

    public List<Lista> buscarListasDeCompras(){
        return listaDAO.readAll();
    }

    public void deleteLista(Integer id) {
        listaDAO.delete(id);
    }

    public void update(Lista lista) {
        listaDAO.update(lista);
    }

    public Lista readById(Integer id) {
        return (Lista) listaDAO.readById(id);
    }
}

