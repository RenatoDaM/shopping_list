package br.com.shoppinglist.controller;

import br.com.shoppinglist.model.Item;
import br.com.shoppinglist.model.ListaItem;
import br.com.shoppinglist.model.TipoItem;
import br.com.shoppinglist.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/shopping_list")
@RestController
public class ItemController {
    final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // ============== ITEM ==============

    @PostMapping("/item")
    public ResponseEntity<Object> saveItem(@RequestBody Item item) {
        itemService.criarItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping("/item")
    public ResponseEntity<List<Item>> readAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.buscarItens());
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> readByIdItem(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.buscarItens().get(id));
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/item")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        itemService.updateItem(item.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ================ TIPO ITEM ================

    @PostMapping("/tipo_item")
    public ResponseEntity<TipoItem> saveTipo(@RequestBody TipoItem tipoItem) {
        itemService.criarTipoItem(tipoItem);
        return ResponseEntity.status(HttpStatus.OK).body(tipoItem);
    }

    @GetMapping("/tipo_item/{id}")
    public ResponseEntity<TipoItem> readByIdTipo(@PathVariable (value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.readByIdTipo(id));
    }

    @GetMapping("tipo_item")
    public ResponseEntity<List<TipoItem>> readAllTipos() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.buscarTipos());
    }

    @PutMapping("/tipo_item")
    public ResponseEntity<TipoItem> updateTipo(@RequestBody TipoItem tipoItem) {
        itemService.updateTipo(tipoItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/tipo_item/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Integer id) {
        itemService.deleteTipo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ================ LISTA ITEM ==================

    @PostMapping("/lista_item")
    public ResponseEntity<ListaItem> criarListaItem(@RequestBody ListaItem listaItem) {
        itemService.criarListaItem(listaItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(listaItem);
    }

    @PutMapping("/lista_item")
    public ResponseEntity<ListaItem> updateListaItem(@RequestBody ListaItem listaItem) {
        itemService.update(listaItem);
        return ResponseEntity.status(HttpStatus.OK).body(listaItem);
    }

    @GetMapping("/lista_item")
    ResponseEntity<List<ListaItem>> readAllListaItem() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.readAll());
    }

    @GetMapping("/lista_item/{listaId}")
    ResponseEntity<ListaItem> readByIdListaItem(@PathVariable (value = "listaId") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.readByIdListaItem(id));
    }

    @DeleteMapping("/lista_item/{listaId}")
    ResponseEntity<Void> deleteListaItem(@PathVariable (value = "listaId") Integer id) {
        itemService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}






