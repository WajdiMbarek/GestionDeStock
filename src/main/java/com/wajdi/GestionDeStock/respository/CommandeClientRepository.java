package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeClientRepository extends JpaRepository<CommandeClient, Integer> {

    Optional<CommandeClient> findByCommandeClientByCode(String code);
}
