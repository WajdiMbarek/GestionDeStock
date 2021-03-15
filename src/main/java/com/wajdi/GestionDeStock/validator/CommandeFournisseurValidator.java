package com.wajdi.GestionDeStock.validator;

import com.wajdi.GestionDeStock.dto.CommandeClientDto;
import com.wajdi.GestionDeStock.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {

    public static List<String> validate(CommandeFournisseurDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto ==  null ){
            errors.add("Veuillez renseigner le code de la commande");
            errors.add("veuillez renseigner la date de la commande");
        }
        if(!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez renseigner le code de la commande");
        }
        if(dto.getDateCommande() == null){
            errors.add("veuillez renseigner la date de la commande");
        }
        if(dto.getFournisseur() == null){
            errors.add("veuillez renseigner la client de la commande");
        }
        return errors;
    }
}
