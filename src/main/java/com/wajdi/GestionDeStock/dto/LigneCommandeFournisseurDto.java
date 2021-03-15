package com.wajdi.GestionDeStock.dto;

import com.wajdi.GestionDeStock.model.LigneCommandeFournisseur;
import com.wajdi.GestionDeStock.model.Roles;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeFournisseurDto{

    private Integer id;

    private ArticleDto article;

    private CommandeFournisseurDto commandeFournisseur;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    //Mapping
    public static  LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
        if (ligneCommandeFournisseur == null){
            return null;
            // TODO throw an exception
        }
        return LigneCommandeFournisseurDto.builder()
                .id(ligneCommandeFournisseur.getId())
                .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
                .article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
                .quantite(ligneCommandeFournisseur.getQuantite())
                .commandeFournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
                .build();
    }
    public static  LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto commandeFournisseurDto){
        if (commandeFournisseurDto == null){
            return null;
            // TODO throw an exception
        }

        LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
        ligneCommandeFournisseur.setId(commandeFournisseurDto.getId());
        ligneCommandeFournisseur.setQuantite(commandeFournisseurDto.getQuantite());
        ligneCommandeFournisseur.setPrixUnitaire(commandeFournisseurDto.getPrixUnitaire());
        ligneCommandeFournisseur.setCommandeFournisseur(CommandeFournisseurDto.toEntity(commandeFournisseurDto.getCommandeFournisseur()));
        ligneCommandeFournisseur.setArticle(ArticleDto.toEntity((commandeFournisseurDto.getArticle())));
        return ligneCommandeFournisseur;

    }
}
