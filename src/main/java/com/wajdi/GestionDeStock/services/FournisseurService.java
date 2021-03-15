package com.wajdi.GestionDeStock.services;

import com.wajdi.GestionDeStock.dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    FournisseurDto save(FournisseurDto dto);

    FournisseurDto findById(Integer id);

    FournisseurDto finbyNom(String nom);

    FournisseurDto findByPrenom(String prenom);

    List<FournisseurDto> findAll();

    void delete(Integer id);
}
