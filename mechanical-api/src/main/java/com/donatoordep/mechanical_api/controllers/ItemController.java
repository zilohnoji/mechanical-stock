package com.donatoordep.mechanical_api.controllers;

import com.donatoordep.mechanical_api.dtos.request.ItemCreateRequestDTO;
import com.donatoordep.mechanical_api.dtos.request.ItemUpdateRequestDTO;
import com.donatoordep.mechanical_api.dtos.response.ItemCreateResponseDTO;
import com.donatoordep.mechanical_api.dtos.response.ItemGetAllResponseDTO;
import com.donatoordep.mechanical_api.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.donatoordep.mechanical_api.controllers.ItemController.PATH;

@RestController
@RequestMapping(path = PATH)
public class ItemController {

    private final ItemService SERVICE;
    public final static String PATH = "/items";

    @Autowired
    public ItemController(ItemService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ItemCreateResponseDTO> createProduct(@RequestBody ItemCreateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(SERVICE.createProduct(request));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        SERVICE.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<ItemGetAllResponseDTO>> findByName(@RequestParam String name) {
        return ResponseEntity.ok().body(SERVICE.findByName(name));
    }

    @PutMapping
    public ResponseEntity<List<ItemGetAllResponseDTO>> updateItem(@RequestBody ItemUpdateRequestDTO request){
        return ResponseEntity.ok().body(SERVICE.updateItem(request));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ItemGetAllResponseDTO>> getAll() {
        return ResponseEntity.ok().body(SERVICE.getAll());
    }
}