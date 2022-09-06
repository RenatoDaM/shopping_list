package main.java.br.com.shoppinglist.model;

public class TipoItem {

    private Integer id;
    private String itemDesc;

    public TipoItem() {
    }

    public TipoItem(Integer id, String itemDesc) {
        this.id = id;
        this.itemDesc = itemDesc;
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

    @Override
    public String toString() {
        return "TipoItem{" +
                "id=" + id +
                ", itemDesc='" + itemDesc + '\'' +
                '}';
    }
}
