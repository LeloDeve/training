package com.zanchetta.training.resoucers;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.domain.Product;
import com.zanchetta.training.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        List<Client> list = clientService.findAll();

        return ResponseEntity.ok().body(list);

    }
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable String id){
        Client client = clientService.findById(id);
        return  ResponseEntity.ok().body(client);
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Client client){
        Client obj = clientService.insert(client);

        //vai retornar uma messagem/cabeçalho com o caminho do novo recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
