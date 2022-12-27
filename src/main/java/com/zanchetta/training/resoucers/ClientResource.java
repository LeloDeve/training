package com.zanchetta.training.resoucers;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.dto.ClientDTO;
import com.zanchetta.training.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        List<ClientDTO> clientDTOList = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());

        return ResponseEntity.ok().body(clientDTOList);

    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable String id) {
        Client client = clientService.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(client));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ClientDTO clientDTO) {
        Client client = clientService.clientFromDTO(clientDTO);
        clientService.insert(client);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        //vai retornar uma messagem/cabeçalho com o caminho do novo recurso criado
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        clientService.delete(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ClientDTO clientDTO, @PathVariable String id) {
        Client client = clientService.clientFromDTO(clientDTO);
        client.setId(id);
        clientService.update(client);
        return ResponseEntity.noContent().build();
    }

}
