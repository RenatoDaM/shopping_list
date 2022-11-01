package br.com.shoppinglist.dao;

import org.springframework.stereotype.Component;

import java.util.List;


public interface CrudDAO {

    void save(Object o);

    /*
     * Utilização de Generics do Java no método readAll e readById, onde o método implementa o retorno considerando qualquer objeto, se tornando genérico.
     * Para isso usamos uma letra maiuscula, geralmente o E ou T para definir o método como genérico, seguindo as implementações abaixo.
     * Dessa forma podemos usar esse método para qualquer uma das DAOs, passando qualquer model.
     */
    <E> List<E> readAll();
    <E> E readById(Integer id);

    void update(Object o);
    void delete(Integer id);

}