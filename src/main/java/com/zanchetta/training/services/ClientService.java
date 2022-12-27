package com.zanchetta.training.services;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.dto.ClientDTO;
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

    public List<Client> findAll() {
        return clientRepository.findAll();

    }

    public Client findById(String id) {
        Optional<Client> client = clientRepository.findById(id); //se nao encontrar o id ele retorna nulo
    /*
        if (client == null){
           throw new ObjectNotFoundException("Objeto nao encontrado");
        }
    */
        return client.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
    }

    public Client insert(Client client) { //metodo retorna um cliente inserido no db
        return clientRepository.insert(client);
    }

    public void delete(String id) { //metodo recebe um id, procura por id e deleta pelo id encontrado
        findById(id);
        clientRepository.deleteById(id);
    }

    public Client update(Client obj) {
        Client newObj = findById(obj.getId());
        updateData(newObj, obj);
        return clientRepository.save(newObj);

    }

    private void updateData(Client newObj, Client obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        newObj.setPhone(obj.getPhone());
    }

    public Client clientFromDTO(ClientDTO objDTO){  //metodo para transformar um dto em cliente

        return new Client(objDTO.getId(), objDTO.getName(), objDTO.getEmail(), objDTO.getPhone());
    }

}
