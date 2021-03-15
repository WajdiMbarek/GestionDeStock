package com.wajdi.GestionDeStock.validator;

import com.wajdi.GestionDeStock.dto.ArticleDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez renseigner le code de l'article");
            errors.add("Veuillez renseigner la disigniation de l'article");
            errors.add("Veuillez renseigner le prix unitaire  de l'article");
            errors.add("Veuillez renseigner le taux TVA de l'article");
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
            errors.add("Veuillez selectionner une categorie");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getCodeArticle())){
            errors.add("Veuillez renseigner le code de l'article");
        }
        if(!StringUtils.hasLength(dto.getDesignation())){
            errors.add("Veuillez renseigner la disigniation de l'article");
        }
        if(dto.getPrixUnitaireHT() == null){
            errors.add("Veuillez renseigner le prix unitaire  de l'article");
        }
        if(dto.getTauxTva() == null){
            errors.add("Veuillez renseigner le taux TVA de l'article");
        }
        if(dto.getPrixUnitaireTtc() == null){
            errors.add("Veuillez renseigner le prix unitaire TTC de l'article");
        }
        if(dto.getCategory() == null){
            errors.add("Veuillez selectionner une categorie");
        }

        return errors;
    }
}
