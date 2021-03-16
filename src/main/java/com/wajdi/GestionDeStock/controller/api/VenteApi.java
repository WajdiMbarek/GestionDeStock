package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.VenteDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wajdi.GestionDeStock.utils.Constants.*;

@Api(VENTE_END_POINT)
public interface VenteApi {

    @PostMapping(CREATE_VENTE_END_POINT)
    VenteDto save(@RequestBody VenteDto dto);

    @GetMapping(FIND_VENTE_BY_ID_END_POINT)
    VenteDto findById(@PathVariable("idVente") Integer id);

    @GetMapping(FIND_VENTE_BY_CODE_END_POINT)
    VenteDto findByCode(@PathVariable("codeVente") String code);

    @GetMapping(FIND_ALL_VENTE_END_POINT)
    List<VenteDto> findAll();

    @DeleteMapping(DELETE_VENTE_BY_ID_END_POINT)
    void delete(@PathVariable("idVente") Integer id);
}
