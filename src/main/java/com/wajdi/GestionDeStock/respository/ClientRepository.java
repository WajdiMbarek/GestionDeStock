package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    Optional<Client> findClientByNom(String nom);

    Optional<Client> findClientByPrenom(String prenom);
}
