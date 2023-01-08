package br.com.shoppinglist.model;

public class Item {

    private Integer id;
    private String itemDesc;

    private Integer tipoItemId;

    public Item() {
    }

    public Item(Integer id, String itemDesc, Double preco, Integer tipoItemId) {
        this.id = id;
        this.itemDesc = itemDesc;
        this.tipoItemId = tipoItemId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Integer getTipoItemId() {
        return tipoItemId;
    }

    public void setTipoItemId(Integer tipoItemId) {
        this.tipoItemId = tipoItemId;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", desc='" + itemDesc + '\'' +
                ", tipoItem=" + tipoItemId;
    }
}
