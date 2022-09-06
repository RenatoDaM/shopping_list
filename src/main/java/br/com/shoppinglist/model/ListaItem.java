package main.java.br.com.shoppinglist.model;

public class ListaItem {

    private Integer listaId;
    private Integer itemId;

    private Integer qtdItem;
    private Double valorTotal;

    public ListaItem() {
    }

    public ListaItem(Integer listaId, Integer itemId, Integer qtdItem, Double valorTotal) {
        this.listaId = listaId;
        this.itemId = itemId;
        this.qtdItem = qtdItem;
        this.valorTotal = valorTotal;
    }

    public Integer getListaId() {
        return listaId;
    }

    public void setListaId(Integer listaId) {
        this.listaId = listaId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(Integer qtdItem) {
        this.qtdItem = qtdItem;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "listaId=" + listaId +
                ", itemId=" + itemId +
                ", qtdItem=" + qtdItem +
                ", valorTotal=" + valorTotal;
    }
}
