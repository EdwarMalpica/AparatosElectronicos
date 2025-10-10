package com.uptc.frw.aparatoselectronicos.resolver;

import com.uptc.frw.aparatoselectronicos.model.Client;
import com.uptc.frw.aparatoselectronicos.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientDataFetcher {

    @Autowired
    private ClientService clientService;

    @QueryMapping
    public List<Client> getClients() {
        return clientService.findAllClients();
    }

    @QueryMapping
    public Client getClientById(@Argument Long id) {
        return clientService.findClientById(id);
    }

    @MutationMapping
    public Client createClient(@Argument String document, @Argument String address, @Argument String email, @Argument String phoneNumber) {
        Client client = new Client(document, address, phoneNumber, email );
        return clientService.saveClient(client);
    }

    @MutationMapping
    public Client updateClient(@Argument Long id,@Argument String document, @Argument String address, @Argument String email, @Argument String phoneNumber) {
        Client client = new Client(id,document, address,phoneNumber, email );
        return clientService.updateClient(client);
    }

    @MutationMapping
    public void deleteClient(@Argument Long id) {
        clientService.deleteClient(id);
    }
}
