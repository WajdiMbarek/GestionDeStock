package com.wajdi.GestionDeStock.services;

import com.wajdi.GestionDeStock.dto.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto dto);

    EntrepriseDto findbyId(Integer id);

    List<EntrepriseDto> findAll();

    void delete(Integer id);

}
