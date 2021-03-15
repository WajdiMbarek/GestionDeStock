package com.wajdi.GestionDeStock.dto;
import com.wajdi.GestionDeStock.model.Article;
import com.wajdi.GestionDeStock.model.CommandeClient;
import com.wajdi.GestionDeStock.model.LigneCommandeClient;
import com.wajdi.GestionDeStock.model.Roles;
import lombok.*;
import java.math.BigDecimal;

@Data
@Builder
public class LigneCommandeClientDto  {

    private Integer id;

    private ArticleDto article;

    private CommandeClientDto commandeClient;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    public static  LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
        if (ligneCommandeClient == null){
            return null;
            // TODO throw an exception
        }
        return LigneCommandeClientDto.builder()
                .id(ligneCommandeClient.getId())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .quantite(ligneCommandeClient.getQuantite())
                .article(ArticleDto.fromEntity(ligneCommandeClient.getArticle()))
                .commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
                .build();
    }
    public static  LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
        if (ligneCommandeClientDto == null){
            return null;
            // TODO throw an exception
        }

        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
        ligneCommandeClient.setId(ligneCommandeClientDto.getId());
        ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
        ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
        ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClient()));
        return ligneCommandeClient;

    }


}
