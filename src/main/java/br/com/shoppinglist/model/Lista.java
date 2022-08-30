package main.java.br.com.shoppinglist.model;

public class Lista {

    private Integer id;
    private String desc;
    private Double valorTotal;
    private Integer qtdItens;

    public Lista() {
    }

    public Lista(Integer id, String desc, Double valorTotal, Integer qtdItens) {
        this.id = id;
        this.desc = desc;
        this.valorTotal = valorTotal;
        this.qtdItens = qtdItens;
    }

    public Integer getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        return "id=" + id + ", desc='" + desc + '\'' + ", valorTotal=" + valorTotal + ", qtdItens=" + qtdItens;
    }
}
