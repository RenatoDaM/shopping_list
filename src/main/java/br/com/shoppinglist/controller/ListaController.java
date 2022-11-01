package br.com.shoppinglist.controller;

import br.com.shoppinglist.model.Lista;
import br.com.shoppinglist.model.ListaItem;
import br.com.shoppinglist.service.ListaDeCompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/shopping_list/lista")
@RestController
public class ListaController {
    final ListaDeCompraService listaService;

    public ListaController (ListaDeCompraService listaService) {
        this.listaService = listaService;
    }


    @PostMapping
    public ResponseEntity<Object> criarLista(Lista lista) {
        listaService.criarListaDeCompras(lista);
        return ResponseEntity.status(HttpStatus.CREATED).body(lista);
    }

    @GetMapping
    public ResponseEntity<List<Lista>> buscarListas() {
        return ResponseEntity.status(HttpStatus.OK).body(listaService.buscarListasDeCompras());
    }
}
