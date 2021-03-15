package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.dto.VenteDto;
import com.wajdi.GestionDeStock.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenteRepository extends JpaRepository<Vente,Integer> {

    Optional<Vente> findVenteByCode(String code);
}
