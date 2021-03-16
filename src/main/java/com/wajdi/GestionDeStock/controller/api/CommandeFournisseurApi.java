package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wajdi.GestionDeStock.utils.Constants.*;

@Api(COMMANDE_FOURNISSEUR_END_POINT)
public interface CommandeFournisseurApi {

    @PostMapping(CREATE_COMMANDE_FOURNISSEUR_END_POINT)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);

    @GetMapping(FIND_COMMANDE_FOURNISSEUR_BY_ID_END_POINT)
    CommandeFournisseurDto findById(@PathVariable("idCommandeFournisseur") Integer id);

    @GetMapping(FIND_COMMANDE_FOURNISSEUR_BY_CODE_END_POINT)
    CommandeFournisseurDto findByCode(@PathVariable("codeCommandeFournisseur")String code);

    @GetMapping(FIND_ALL_COMMANDE_FOURNISSEUR_END_POINT)
    List<CommandeFournisseurDto> findAll();

    @DeleteMapping(DELETE_COMMANDE_FOURNISSEUR_BY_ID_END_POINT)
    void delete(@PathVariable("idCommandeFournisseur") Integer id);

}
