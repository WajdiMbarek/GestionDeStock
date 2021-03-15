package com.wajdi.GestionDeStock.services;

import com.wajdi.GestionDeStock.dto.CommandeClientDto;
import com.wajdi.GestionDeStock.dto.VenteDto;

import java.util.List;

public interface VenteService {
    VenteDto save(VenteDto dto);

    VenteDto findById(Integer id);

    VenteDto findByCode(String code);

    List<VenteDto> findAll();

    void delete(Integer id);
}
