package br.com.shoppinglist.model;



public class TipoItem {

    private int id;
    private String tipoDesc;

    public TipoItem(int id, String tipoDesc) {
        this.id = id;
        this.tipoDesc = tipoDesc;
    }
    public TipoItem() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getTipoDesc() {
        return tipoDesc;
    }

    public void setTipoDesc(String tipoDesc) {
        this.tipoDesc = tipoDesc;

    }

    @Override
    public String toString() {

        return
                "id=" + id +
                ", desc='" + tipoDesc + '\''
                ;

    }
}
