package br.com.shoppinglist.service;

import br.com.shoppinglist.dao.CrudDAO;
import br.com.shoppinglist.dao.impl.TipoItemDAOImpl;
import br.com.shoppinglist.model.TipoItem;
import java.util.List;

public class TipoItemService {

    private final CrudDAO crudDAO;

    public TipoItemService() { this.crudDAO = new TipoItemDAOImpl(); }

    public void criarTipoDeItem(TipoItem tipoItem) {
        boolean tipoUnico = true;
        List<TipoItem> tipos = buscarTipoDeItens();
        if (!tipos.isEmpty()) {
            for (TipoItem tI : tipos) {
                if (tI.getDesc().equalsIgnoreCase(tipoItem.getDesc())) {
                    System.out.println("-- Já existe este tipo de item --");
                    System.out.println("-- Tipo de item não criado... --");
                    tipoUnico = false;
                }
            }
        }
        if (tipoUnico) crudDAO.save(tipoItem);

    }


    public List<TipoItem> buscarTipoDeItens() {
        List<TipoItem> tipo = crudDAO.readAll();
        return tipo;
    }

    public void save(Object o) {
        crudDAO.save(o);

    }

    public void readById(Integer id) {
        crudDAO.readById(id);
    }

    public void update(Object o) {
        crudDAO.update(o);
    }

    public void delete(Integer id) {
        crudDAO.delete(id);
    }

}
