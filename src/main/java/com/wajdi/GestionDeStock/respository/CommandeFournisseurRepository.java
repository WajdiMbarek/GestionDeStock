package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.model.CommandeClient;
import com.wajdi.GestionDeStock.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandeFournisseurRepository extends JpaRepository<CommandeFournisseur, Integer> {

    Optional<CommandeFournisseur> findByCommandeFournisseurByCode(String code);

}
