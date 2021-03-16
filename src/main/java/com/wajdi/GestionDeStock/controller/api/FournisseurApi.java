package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.FournisseurDto;
import static  com.wajdi.GestionDeStock.utils.Constants.*;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(FOURNISSEUR_END_POINT)
public interface FournisseurApi {

    @PostMapping(CREATE_FOURNISSEUR_END_POINT)
    FournisseurDto save(@RequestBody FournisseurDto dto);

    @GetMapping(FIND_FOURNISSEUR_BY_ID_END_POINT)
    FournisseurDto findById(@PathVariable("idFournisseur") Integer id);

    @GetMapping(FIND_FOURNISSEUR_BY_NOM_END_POINT)
    FournisseurDto finbyNom(@PathVariable("nomFournisseur") String nom);

    @GetMapping(FIND_FOURNISSEUR_BY_PRENOM_END_POINT)
    FournisseurDto findByPrenom( @PathVariable("prenomFournisseur") String prenom);

    @GetMapping(FIND_ALL_FOURNISSEUR_END_POINT)
    List<FournisseurDto> findAll();

    @DeleteMapping(DELETE_FOURNISSEUR_BY_ID_END_POINT)
    void delete(@PathVariable("idFournisseur")  Integer id);
}
