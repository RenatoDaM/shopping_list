package br.com.shoppinglist.model;

public class Item {

    private Integer id;
    private String desc;
    private Double preco;

    private Integer tipoItemId;

    public Item() {
    }

    public Item(Integer id, String desc, Double preco, Integer tipoItemId) {
        this.id = id;
        this.desc = desc;
        this.preco = preco;
        this.tipoItemId = tipoItemId;
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

    public Integer getTipoItemId() {
        return tipoItemId;
    }

    public void setTipoItemId(Integer tipoItemId) {
        this.tipoItemId = tipoItemId;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", desc='" + desc + '\'' +
                ", preco=" + preco +
                ", tipoItem=" + tipoItemId;
    }
}
