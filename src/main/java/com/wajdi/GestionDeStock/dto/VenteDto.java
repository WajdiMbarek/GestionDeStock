package com.wajdi.GestionDeStock.dto;

import com.wajdi.GestionDeStock.model.LigneVente;
import com.wajdi.GestionDeStock.model.Roles;
import com.wajdi.GestionDeStock.model.Vente;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class VenteDto{

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    private List<LigneVenteDto> ligneVentes;

    public static  VenteDto fromEntity(Vente vente){
        if (vente == null){
            return null;
            // TODO throw an exception
        }
        return VenteDto.builder()
                .id(vente.getId())
                .code(vente.getCode())
                .dateVente(vente.getDateVente())
                .commentaire(vente.getCommentaire())
                .build();
    }
    public static  Vente toEntity(VenteDto venteDto){
        if (venteDto == null){
            return null;
            // TODO throw an exception
        }

        Vente vente = new Vente();
        vente.setId(venteDto.getId());
        vente.setCode(venteDto.getCode());
        vente.setCommentaire(venteDto.getCommentaire());
        vente.setDateVente(venteDto.getDateVente());
        return vente;

    }
}
