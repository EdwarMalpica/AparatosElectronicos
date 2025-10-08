package com.uptc.frw.aparatoselectronicos.service;

import com.uptc.frw.aparatoselectronicos.model.Client;
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
}
