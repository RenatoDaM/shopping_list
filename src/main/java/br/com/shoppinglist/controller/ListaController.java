package br.com.shoppinglist.controller;

import br.com.shoppinglist.model.Lista;
import br.com.shoppinglist.service.ListaDeCompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/lista")
@RestController
public class ListaController {
    final ListaDeCompraService listaService;

    public ListaController (ListaDeCompraService listaService) {
        this.listaService = listaService;
    }


    @PostMapping("/criar")
    public ResponseEntity<Object> criarLista(@RequestBody Lista lista) {
        listaService.criarListaDeCompras(lista);
        return ResponseEntity.status(HttpStatus.CREATED).body(lista);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Lista>> buscarListas() {
        return ResponseEntity.status(HttpStatus.OK).body(listaService.buscarListasDeCompras());
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLista(@PathVariable (value = "id") Integer id) {
        listaService.deleteLista(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Lista> updateLista(@RequestBody Lista lista) {
        listaService.update(lista);
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }
}
