package com.wajdi.GestionDeStock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mvtStk")
public class MvtStk extends AbstractEntity {

    @Column(name = "dateMvt")
    private Instant dateMvt;

    @Column(name = "quatite")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Article article;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "typeMvt")
    private TypeMvtStk typeMvt;

}
