package com.zanchetta.training.services;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.repository.ClientRepository;
import com.zanchetta.training.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();

    }
    public Client findById(String id){
        Optional<Client> client = clientRepository.findById(id); //se nao encontrar o id ele retorna nulo
        //if (client == null){
         //   throw new ObjectNotFoundException("Objeto nao encontrado");
        //}
            return client.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado"));
    }

}
