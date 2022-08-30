package main.java.br.com.shoppinglist.dao;

import java.util.List;

public interface CrudDAO {

    void save(Object o);

    /*
     * Utilização de Generics do Java no método readAll e readById, onde o método recebe ou devolve qualquer objeto, se tornando genérico.
     * Para isso usamos uma letra maiuscula, geralmente o E ou T para definir o método como genérico, seguindo as implementações abaixo.
     * Dessa forma podemos usar esse método para qualquer uma das DAOs, passando qualquer model.
     */
    <E> List<E> readAll();
    <E> E readById(Integer id);

    void update(Object o);
    void delete(Object o);

}
