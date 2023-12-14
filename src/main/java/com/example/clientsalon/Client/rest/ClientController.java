package com.example.clientsalon.Client.rest;

import com.example.clientsalon.Client.dtos.CreateClientRequest;
import com.example.clientsalon.Client.dtos.CreateClientResponse;
import com.example.clientsalon.Client.dtos.UpdateClientRequest;
import com.example.clientsalon.Client.model.Client;
import com.example.clientsalon.Client.service.ClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@AllArgsConstructor
@Slf4j
public class ClientController {

    private ClientService clientService;

    @GetMapping("/allClientu")
    public ResponseEntity<List<Client>> getAllClienti() {
        List<Client> clienti=clientService.getAllClienti();
        return new ResponseEntity<>(clienti, HttpStatus.OK);
    }



    @PostMapping("/createClient")
    public ResponseEntity<CreateClientResponse>addClient(@RequestBody CreateClientRequest createClientRequest){
        CreateClientResponse createClientResponse=clientService.addClient(createClientRequest);
        return new ResponseEntity<>(createClientResponse,HttpStatus.CREATED);
    }

    @PutMapping("/updateClient")
    public ResponseEntity<Void> updateClient(@RequestBody UpdateClientRequest updateClientRequest){
        clientService.updateClient(updateClientRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @DeleteMapping
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }



}
