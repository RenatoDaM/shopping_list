package br.com.shoppinglist.service;

import br.com.shoppinglist.dao.impl.ItemDAOImpl;
import br.com.shoppinglist.dao.impl.ListaItemDAOImpl;
import br.com.shoppinglist.dao.impl.TipoItemDAOImpl;
import br.com.shoppinglist.model.Item;
import br.com.shoppinglist.model.ListaItem;
import br.com.shoppinglist.model.TipoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemDAOImpl itemDAO;
    @Autowired
    private TipoItemDAOImpl tipoItemDAO;
    @Autowired
    private ListaItemDAOImpl listaItemDAO;


    // =================== ITEM ===================

    public void criarItem(Item item) {
        itemDAO.save(item);
    }



    public List<Item> buscarItens() {
        List<Item> tipo = itemDAO.readAll();
        return tipo;
    }

    public Item readByIdItem(Integer id) {
       return  itemDAO.readById(id);
    }

    public void updateItem(Object o) {
        itemDAO.update(o);
    }

    public void deleteItem(Integer id) {
        itemDAO.delete(id);
    }

    // ============= TIPO ITEM ==============
    public void criarTipoItem(TipoItem tipoItem) {
        boolean tipoUnico = true;
        List<TipoItem> resultList = buscarTipos();
        if (!resultList.isEmpty()) {
            for (TipoItem tipoItemTeste : resultList) {
                if (tipoItemTeste.getTipoDesc().equalsIgnoreCase(tipoItem.getTipoDesc())) {
                    System.out.println("Tipo de Item não criado. Este tipo de item já existe");
                    tipoUnico = false;
                }
            }
        }
        if (tipoUnico) tipoItemDAO.save(tipoItem);
    }

    public List<TipoItem> buscarTipos() {
        List<TipoItem> list = tipoItemDAO.readAll();
        return list;
    }

    public TipoItem readByIdTipo(Integer id) {
        return tipoItemDAO.readById(id);
    }

    public void updateTipo(Object o) {
        tipoItemDAO.update(o);
    }

    public void deleteTipo(Integer id) {
        tipoItemDAO.delete(id);
    }

    public boolean existsByItemDesc(Item item) {
        return itemDAO.readAll().stream().anyMatch(e -> e.getItemDesc().equals(item.getItemDesc()));
    }

    // ================== LISTA ITEM =====================
    public ListaItem readByIdListaItem(Integer id) {
        return listaItemDAO.readById(id);
    }

    public List<ListaItem> readAll() {
        List<ListaItem> resultList = listaItemDAO.readAll();
        return resultList;
    }

    public void update(ListaItem listaItem) {
        listaItemDAO.update(listaItem);
    }

    public void delete(Integer id) {
        listaItemDAO.delete(id);
    }

    public void criarListaItem(ListaItem listaItem) {
        listaItemDAO.save(listaItem);
    }


}
