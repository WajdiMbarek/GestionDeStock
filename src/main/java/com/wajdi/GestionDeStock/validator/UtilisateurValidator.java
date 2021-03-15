package com.wajdi.GestionDeStock.validator;

import com.wajdi.GestionDeStock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();
        if(utilisateurDto == null) {
            errors.add("veuillez renseigner le nom de l'utilisateur");
            errors.add("veuillez renseigner le prenom de l'utilisateur");
            errors.add("veuillez renseigner le mot de passe de l'utilisateur");
            errors.add("veuillez renseigner l'adresse de l'utilisateur");
            return errors;
        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("veuillez renseigner le nom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("veuillez renseigner le prenom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("veuillez renseigner le mot de passe de l'utilisateur");
        }
        if(utilisateurDto.getDateDeNaissance() == null){
            errors.add("veuillez renseigner la date de naissance de l'utilisateur");
        }
        if(utilisateurDto.getAdresse() == null){
            errors.add("veuillez renseigner l'adresse de l'utilisateur");
        } else {
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getAdresse1())) {
                errors.add("Le champ 'adresse 1' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getVille())){
                errors.add("Le champ 'ville' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getCodePostale())){
                errors.add("Le champ 'Code Postale' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresse().getPays())){
                errors.add("Le champ 'Pays' est obligatoire");
            }

        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("veuillez renseigner le nom de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("veuillez renseigner le nom de l'utilisateur");
        }
        return errors;
    }
}
