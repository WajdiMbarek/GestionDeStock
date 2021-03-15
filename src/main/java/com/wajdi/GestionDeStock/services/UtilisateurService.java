package com.wajdi.GestionDeStock.services;

import com.wajdi.GestionDeStock.dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    UtilisateurDto save(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    UtilisateurDto finbyNom(String nom);

    UtilisateurDto findByPrenom(String prenom);

    List<UtilisateurDto> findAll();

    void delete(Integer id);
}
