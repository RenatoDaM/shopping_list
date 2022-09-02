package main.java.br.com.shoppinglist.model;

public class Item {

    private Integer id;
    private String desc;
    private Double preco;

    private TipoItem tipoItem;

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public TipoItem getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItem tipoItem) {
        this.tipoItem = tipoItem;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", desc='" + desc + '\'' +
                ", preco=" + preco +
                ", tipoItem=" + tipoItem;
    }
}
