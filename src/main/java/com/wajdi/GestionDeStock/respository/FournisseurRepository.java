package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Integer> {

    Optional<Fournisseur> findFournisseurByNom(String nom);

    Optional<Fournisseur> findFournisseurByPrenom(String prenom);
}
