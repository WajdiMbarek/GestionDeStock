package com.wajdi.GestionDeStock.controller.api;

import static com.wajdi.GestionDeStock.utils.Constants.*;

import com.wajdi.GestionDeStock.dto.UtilisateurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Api(UTILISATEUR_END_POINT)
public interface UtilisateurApi {

    @PostMapping(CREATE_UTILISATEUR_END_POINT)
    UtilisateurDto save(UtilisateurDto dto);

    @GetMapping(FIND_UTILISATEUR_BY_ID_END_POINT)
    UtilisateurDto findById(@PathVariable("idUtilisateur") Integer id);

    @GetMapping(FIND_UTILISATEUR_BY_NOM_END_POINT)
    UtilisateurDto finbyNom(@PathVariable("nomUtilisateur")String nom);

    @GetMapping(FIND_UTILISATEUR_BY_PRENOM_END_POINT)
    UtilisateurDto findByPrenom(@PathVariable("prenomUtilisateur")String prenom);

    @GetMapping(FIND_ALL_UTILISATEUR_END_POINT)
    List<UtilisateurDto> findAll();

    @DeleteMapping(DELETE_UTILISATEUR_BY_ID_END_POINT)
    void delete(@PathVariable("idUtilisateur") Integer id);

}
