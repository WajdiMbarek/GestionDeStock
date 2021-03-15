package com.wajdi.GestionDeStock.dto;

import com.wajdi.GestionDeStock.model.LigneVente;
import com.wajdi.GestionDeStock.model.Roles;
import com.wajdi.GestionDeStock.model.Vente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneVenteDto{

    private Integer id;

    private VenteDto vente;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private ArticleDto article;

    public static  LigneVenteDto fromEntity(LigneVente ligneVente){
        if (ligneVente == null){
            return null;
            // TODO throw an exception
        }
        return LigneVenteDto.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getPrixUnitaire())
                .vente(VenteDto.fromEntity(ligneVente.getVente()))
                .build();
    }
    public static  LigneVente toEntity(LigneVenteDto ligneVenteDto){
        if (ligneVenteDto == null){
            return null;
            // TODO throw an exception
        }

        LigneVente ligneVente = new LigneVente();
        ligneVente.setId(ligneVenteDto.getId());
        ligneVente.setQuantite(ligneVenteDto.getQuantite());
        ligneVente.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
        ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));
        return ligneVente;

    }
}
