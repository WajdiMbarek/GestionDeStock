package com.wajdi.GestionDeStock.validator;
import com.wajdi.GestionDeStock.dto.CommandeClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeClientValidator {
    public static List<String> validate(CommandeClientDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto ==  null ){
            errors.add("Veuillez renseigner le code de la commande");
            return errors;
        }
        if(!StringUtils.hasLength(dto.getCode())){
            errors.add("Veuillez renseigner le code de la commande");
        }
        if(dto.getDateCommande() == null){
            errors.add("veuillez renseigner la date de la commande");
        }
        if(dto.getClient() == null){
            errors.add("veuillez renseigner la client de la commande");
        }
    return errors;
    }
}
