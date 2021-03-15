package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findUtilisateurByNom(String nom);

    Optional<Utilisateur> findUtilisateurByPrenom(String prenom);
}
