package main.java.br.com.shoppinglist.model;

public class Lista {

    public Lista() {
    }

    public Lista(Integer id, String desc, Double valorTotal) {
        this.id = id;
        this.desc = desc;
        this.valorTotal = valorTotal;
    }

    private Integer id;
    private String desc;
    private Double valorTotal;

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
}
