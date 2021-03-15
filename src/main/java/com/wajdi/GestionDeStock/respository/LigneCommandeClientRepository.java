package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.model.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient, Integer> {
}
