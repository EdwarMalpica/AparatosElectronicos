package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.model.Client;
import com.uptc.frw.aparatoselectronicos.model.Repair;
import com.uptc.frw.aparatoselectronicos.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    public Client findClientById (Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client saveClient (Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient (Client client) {
        Client newClient = findClientById(client.getId());
        if(newClient != null){
            newClient.setAddress(client.getAddress());
            newClient.setDocument(client.getDocument());
            newClient.setEmail(client.getEmail());
            newClient.setPhoneNumber(client.getPhoneNumber());
            return clientRepository.save(newClient);
        }else {
            throw new RuntimeException("No se encontró el registro a editar");
        }
    }

    public void deleteClient (Long id) {
        clientRepository.deleteById(id);
    }

}
