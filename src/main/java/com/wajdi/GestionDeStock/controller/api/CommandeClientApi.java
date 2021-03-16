package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wajdi.GestionDeStock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/commandesclients")
public interface CommandeClientApi {

    @PostMapping(APP_ROOT + "/commandesclients/create")
    ResponseEntity<CommandeClientDto> save(@RequestBody CommandeClientDto dto);

    @GetMapping(APP_ROOT + "/commandesclients/{idCommandeClient}")
    ResponseEntity<CommandeClientDto> findById(@PathVariable Integer idCommandeClient);

    @GetMapping(APP_ROOT + "/commandesclients/{codeCommandeClient}")
    ResponseEntity<CommandeClientDto> findByCode(@PathVariable("codeCommandeClient") String code);

    @GetMapping(APP_ROOT + "/commandesclients/all")
    ResponseEntity<List<CommandeClientDto>> findAll();

    @DeleteMapping(APP_ROOT + "/commandesclients/{idCommandeCLient}")
    ResponseEntity delete(@PathVariable("idCommandeCLient") Integer id);
}
