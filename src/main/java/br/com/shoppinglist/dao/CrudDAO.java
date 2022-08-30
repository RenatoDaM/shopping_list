package main.java.br.com.shoppinglist.dao;

import java.util.List;

public interface CrudDAO {

    void save(Object o);

    /*
     * Utilização de Generics do Java no método readeList, onde o método recebe a qualquer objeto, se tornando genérico.
     * Para isso usamos uma letra maiuscula, geralmente o E para definir o método como genérico, seguindo a implementação abaixo.
     * Desa froma podemos usar esse método para qualquer umas das DAOs, passando qualquer model.
     */
    <E> List<E> readList();
    
    void update(Object o);
    void delete(Object o);

}
