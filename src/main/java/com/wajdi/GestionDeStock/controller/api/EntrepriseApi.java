package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.EntrepriseDto;
import static com.wajdi.GestionDeStock.utils.Constants.*;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(ENTREPRISE_END_POINT)
public interface EntrepriseApi {

    @PostMapping(CREATE_ENTREPRISE_END_POINT)
    EntrepriseDto save(@RequestBody EntrepriseDto dto);

    @GetMapping(FIND_ENTREPRISE_BY_ID_END_POINT)
    EntrepriseDto findbyId(@PathVariable("idEntreprise") Integer id);

    @GetMapping(FIND_ALL_ENTREPRISE_END_POINT)
    List<EntrepriseDto> findAll();

    @DeleteMapping(DELETE_ENTREPRISE_BY_ID_END_POINT)
    void delete(@PathVariable("idEntreprise") Integer id);
}
