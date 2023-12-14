package com.example.clientsalon.Client.service;

import com.example.clientsalon.Client.dtos.CreateClientRequest;
import com.example.clientsalon.Client.dtos.CreateClientResponse;
import com.example.clientsalon.Client.dtos.UpdateClientRequest;
import com.example.clientsalon.Client.exceptions.ClientDoesntExistException;
import com.example.clientsalon.Client.exceptions.ClientExistException;
import com.example.clientsalon.Client.exceptions.NoUpdateException;
import com.example.clientsalon.Client.model.Client;
import com.example.clientsalon.Client.repository.ClientRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public List<Client> getAllClienti(){
        List<Client>all=clientRepo.findAll();
        if(all.size()==0){
            throw new ClientExistException();
        }
        return all;
    }

    @Transactional

    public CreateClientResponse addClient(CreateClientRequest createClientRequest){
        Optional<Client> clientByNume=clientRepo.findClientByNume(createClientRequest.getNume());

        if(clientByNume.isPresent()){
            throw  new ClientExistException();
        }

        Client client=Client.builder()
                .nume(createClientRequest.getNume())
                .numeEstetician(createClientRequest.getNumeEstetician())
                .descriereProgramareSalon(createClientRequest.getDescriereProgramareSalon())
                .build();


       Client client1=clientRepo.saveAndFlush(client);

        return CreateClientResponse.builder().client(client1).build();
    }

    @Transactional
    public void deleteClient(long id){
        Optional<Client>client=clientRepo.findById(id);

        if(client.isPresent()){
            clientRepo.delete(client.get());
        }
        else{
            throw new ClientDoesntExistException();
        }
    }

    @Transactional
    public void updateClient(UpdateClientRequest updateClientRequest){
        Optional<Client> clientOptional= clientRepo.findClientByNume(updateClientRequest.getNume());

        if(clientOptional.isPresent()){
            Client client=clientOptional.get();

            if(!updateClientRequest.getNumeEstetician().equals("")){
                client.setNumeEstetician(updateClientRequest.getNumeEstetician());
            }

            clientRepo.saveAndFlush(client);
        }


        else {
            throw new NoUpdateException();
        }
    }


}
