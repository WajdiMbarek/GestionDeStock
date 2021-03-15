package com.wajdi.GestionDeStock.validator;

import com.wajdi.GestionDeStock.dto.CommandeClientDto;
import com.wajdi.GestionDeStock.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
    public static List<String> validate(EntrepriseDto dto) {

        List<String> errors = new ArrayList<>();

        if (dto ==  null ){
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("veuillez renseigner la date de la entreprise");
            errors.add("Veuillez renseigner la description de l'entreprise");
            errors.add("Veuillez renseigner le numero de telephone de l'entreprise");
            errors.add("Veuillez renseigner l'email de l'entreprise");
            errors.add("Veuillez renseigner la photo de l'entreprise");
            errors.add("Veuillez renseigner le site web de l'entreprise");
            errors.add("Veuillez renseigner le site web de l'entreprise");
            errors.add("Le champ 'adresse 1' est obligatoire");
            errors.add("Le champ 'ville' est obligatoire");
            errors.add("Le champ 'Code Postale' est obligatoire");
            errors.add("Le champ 'Pays' est obligatoire");
            return errors;
        }
        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if(!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veuillez renseigner la description de l'entreprise");
        }
        if(!StringUtils.hasLength(dto.getNumTel())){
            errors.add("Veuillez renseigner le numero de telephone de l'entreprise");
        }
        if(!StringUtils.hasLength(dto.getEmail())){
            errors.add("Veuillez renseigner l'email de l'entreprise");
        }
        if(!StringUtils.hasLength(dto.getPhoto())){
            errors.add("Veuillez renseigner la photo de l'entreprise");
        }

        if(!StringUtils.hasLength(dto.getSiteWeb())){
            errors.add("Veuillez renseigner le site web de l'entreprise");
        }
        if(dto.getAdresse() == null){
            errors.add("veuillez renseigner l'adresse de l'entreprise");
        } else {
            if(!StringUtils.hasLength(dto.getAdresse().getAdresse1())) {
                errors.add("Le champ 'adresse 1' est obligatoire");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getVille())){
                errors.add("Le champ 'ville' est obligatoire");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getCodePostale())){
                errors.add("Le champ 'Code Postale' est obligatoire");
            }
            if(!StringUtils.hasLength(dto.getAdresse().getPays())){
                errors.add("Le champ 'Pays' est obligatoire");
            }

        }



        return errors;
    }
}
