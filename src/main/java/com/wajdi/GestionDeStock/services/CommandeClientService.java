package com.wajdi.GestionDeStock.services;

import com.wajdi.GestionDeStock.dto.CategoryDto;
import com.wajdi.GestionDeStock.dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {
    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findById(Integer id);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void delete(Integer id);
}
