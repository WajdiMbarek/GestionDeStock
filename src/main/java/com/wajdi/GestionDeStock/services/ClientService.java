package com.wajdi.GestionDeStock.services;

import com.wajdi.GestionDeStock.dto.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto save(ClientDto dto);

    ClientDto findById(Integer id);

    ClientDto finbyNom(String nom);

    ClientDto findByPrenom(String prenom);

    List<ClientDto> findAll();

    void delete(Integer id);
}
