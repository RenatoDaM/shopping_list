package br.com.shoppinglist.controller;

import br.com.shoppinglist.model.Item;
import br.com.shoppinglist.model.ListaItem;
import br.com.shoppinglist.model.TipoItem;
import br.com.shoppinglist.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/v1/item")
@RestController
public class ItemController {
    final ItemService itemService;
    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/criar")
    public ResponseEntity<Object> saveItem(@RequestBody Item item) {
        if(!itemService.existsByItemDesc(item)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(item);
        } else {
            log.error("Já existe um item com esta descrição.");
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um item com esta descrição");
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Item>> readAllItems() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.buscarItens());
    }

    @GetMapping("/buscar/item")
    public ResponseEntity<Item> readByIdItem(@RequestParam(required = true)  Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.readByIdItem(id));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deleteItem(@PathVariable Integer id) {
        try {
            boolean matchDelete = itemService.buscarItens().stream().anyMatch(e -> e.getTipoItemId().equals(id));
            if (matchDelete) {
                itemService.deleteItem(id);
                log.warn("ITEM COM O ID {} FOI DELETADO.", id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                log.error("Não foi encontrado um item com este ID");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado um item com este ID");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/item")
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ================ TIPO ITEM ================

    @PostMapping("/criar_tipo_item")
    public ResponseEntity<TipoItem> saveTipo(@RequestBody TipoItem tipoItem) {
        itemService.criarTipoItem(tipoItem);
        return ResponseEntity.status(HttpStatus.OK).body(tipoItem);
    }

    @GetMapping("/buscar_tipo_item/tipo_item")
    public ResponseEntity<TipoItem> readByIdTipo(@RequestParam(required = true) Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.readByIdTipo(id));
    }

    @GetMapping("/buscar_tipo_item")
    public ResponseEntity<List<TipoItem>> readAllTipos() {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.buscarTipos());
    }

    @PutMapping("/tipo_item")
    public ResponseEntity<TipoItem> updateTipo(@RequestBody TipoItem tipoItem) {
        itemService.updateTipo(tipoItem);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deletar_tipo_item/{id}")
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






