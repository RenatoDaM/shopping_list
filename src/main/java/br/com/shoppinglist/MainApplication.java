package br.com.shoppinglist;


import br.com.shoppinglist.dao.impl.ItemDAOImpl;
import br.com.shoppinglist.dao.impl.ListaDAOImpl;
import br.com.shoppinglist.dao.impl.ListaItemDAOImpl;
import br.com.shoppinglist.dao.impl.TipoItemDAOImpl;
import br.com.shoppinglist.model.Item;
import br.com.shoppinglist.model.Lista;
import br.com.shoppinglist.model.ListaItem;
import br.com.shoppinglist.model.TipoItem;
import br.com.shoppinglist.service.ItemService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MainApplication.class, args);






    }
}

