package com.zanchetta.training.config;

import com.zanchetta.training.domain.Client;
import com.zanchetta.training.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Initialization implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void run(String... args) throws Exception {

        clientRepository.deleteAll();

        Client leandro = new Client(null, "Leandro", "leandro@gmail.com", "985091305");
        Client maria = new Client(null, "Maria", "maria@gmail.com", "985095555");
        Client joao = new Client(null, "joao", "joao@gmail.com", "933091305");
        Client junior = new Client(null, "junior", "junior@gmail.com", "985044405");

        clientRepository.saveAll(Arrays.asList(leandro, maria, joao, junior));


    }
}
