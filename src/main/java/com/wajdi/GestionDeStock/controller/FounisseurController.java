package com.wajdi.GestionDeStock.controller;

import com.wajdi.GestionDeStock.controller.api.FournisseurApi;
import com.wajdi.GestionDeStock.dto.FournisseurDto;
import com.wajdi.GestionDeStock.services.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FounisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;

    @Autowired
    public FounisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        return fournisseurService.save(dto);
    }

    @Override
    public FournisseurDto findById(Integer id) {
        return fournisseurService.findById(id);
    }

    @Override
    public FournisseurDto finbyNom(String nom) {
        return fournisseurService.finbyNom(nom);
    }

    @Override
    public FournisseurDto findByPrenom(String prenom) {
        return fournisseurService.findByPrenom(prenom);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseurService.delete(id);
    }
}
