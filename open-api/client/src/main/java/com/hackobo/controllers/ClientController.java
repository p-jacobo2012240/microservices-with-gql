package com.hackobo.controllers;

import com.hackobo.entities.Client;
import com.hackobo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> allClients() {
        return this.clientRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> storeClient(@RequestBody Client client ) {
        Client storedClient = this.clientRepository.save(client);
        return ResponseEntity.ok(storedClient);
    }
}
