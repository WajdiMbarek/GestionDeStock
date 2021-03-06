package com.wajdi.GestionDeStock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name= "article")
public class Article extends AbstractEntity{

    @Column(name= "codearticle")
    private  String codeArticle;

    @Column(name= "designation")
    private String designation;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "prixunitaireht")
    private BigDecimal prixUnitaireHT;

    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name= "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private  Category category;
}
