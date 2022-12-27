package com.zanchetta.training.resoucers;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.domain.Product;
import com.zanchetta.training.dto.ClientDTO;
import com.zanchetta.training.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<Client> list = clientService.findAll();
        List<ClientDTO> clientDTOList = list.stream().map(x-> new ClientDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(clientDTOList);

    }
    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable String id){
        Client client = clientService.findById(id);
        return  ResponseEntity.ok().body(new ClientDTO(client));
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Client client){
        Client obj = clientService.insert(client);

        //vai retornar uma messagem/cabeçalho com o caminho do novo recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
