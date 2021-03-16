package com.wajdi.GestionDeStock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

   // @CreatedDate
    @Column(name="creationDate")
    private Instant creationDate;

   // @LastModifiedBy
    @Column(name = "lastModifiedDate")
    private Instant lastUpDate;

    @PrePersist
    void prePersist(){
        creationDate = Instant.now();
    }

    @PreUpdate
    void preUpdate(){
        lastUpDate = Instant.now();
    }

}
