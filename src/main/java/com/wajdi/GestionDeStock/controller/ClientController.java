package com.wajdi.GestionDeStock.controller;

import com.wajdi.GestionDeStock.controller.api.ClientApi;
import com.wajdi.GestionDeStock.dto.ClientDto;
import com.wajdi.GestionDeStock.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        return clientService.save(dto);
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto finbyNom(String nom) {
        return clientService.finbyNom(nom);
    }

    @Override
    public ClientDto findByPrenom(String prenom) {
        return clientService.findByPrenom(prenom);
    }

    @Override
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientService.delete(id);
    }
}
