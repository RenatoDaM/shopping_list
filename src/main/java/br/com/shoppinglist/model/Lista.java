package br.com.shoppinglist.model;

public class Lista {

    private Integer id;
    private String listDesc;
    private Double valorTotal;
    private Integer qtdItens;

    public Lista() {
    }

    public Lista(Integer id, String listDesc, Double valorTotal, Integer qtdItens) {
        this.id = id;
        this.listDesc = listDesc;
        this.valorTotal = valorTotal;
        this.qtdItens = qtdItens;
    }

    public Integer getId() {
        return id;
    }

    public String getListDesc() {
        return listDesc;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setListDesc(String listDesc) {
        this.listDesc = listDesc;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(Integer qtdItens) {
        this.qtdItens = qtdItens;
    }

    @Override
    public String toString() {
        return " [id=" + id + ", desc='" + listDesc + '\'' + ", valorTotal=" + valorTotal + ", qtdItens=" + qtdItens + "] ";
    }
}
