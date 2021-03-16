package com.wajdi.GestionDeStock.services;

import com.wajdi.GestionDeStock.controller.api.UtilisateurApi;
import com.wajdi.GestionDeStock.dto.UtilisateurDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {

    private UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        return utilisateurService.save(dto);
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }

    @Override
    public UtilisateurDto finbyNom(String nom) {
        return utilisateurService.finbyNom(nom);
    }

    @Override
    public UtilisateurDto findByPrenom(String prenom) {
        return utilisateurService.findByPrenom(prenom);
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
