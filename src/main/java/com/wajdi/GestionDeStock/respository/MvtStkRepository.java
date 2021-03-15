package com.wajdi.GestionDeStock.respository;

import com.wajdi.GestionDeStock.model.MvtStk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MvtStkRepository extends JpaRepository<MvtStk, Integer> {
}
