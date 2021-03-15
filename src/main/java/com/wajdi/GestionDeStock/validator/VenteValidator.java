package com.wajdi.GestionDeStock.validator;

import com.wajdi.GestionDeStock.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {

    public static List<String> validate(VenteDto dto) {
        List<String> errors = new ArrayList<>();

        if(dto == null){
            errors.add("Veuillez renseignier le code de la vente");
            errors.add("Veuillez renseignier le commentaire de la vente");
            errors.add("Veuillez renseignier la date de la vente");
            return errors;
        }

        if (!StringUtils.hasLength(dto.getCode())) {
            errors.add("Veuillez renseignier le code de la vente");
        }
        if (!StringUtils.hasLength(dto.getCommentaire())) {
            errors.add("Veuillez renseignier le commentaire de la vente");
        }
        if (dto.getDateVente() == null) {
            errors.add("Veuillez renseignier la date de la vente");
        }
    return errors;
    }
}
