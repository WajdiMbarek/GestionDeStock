package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.ClientDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wajdi.GestionDeStock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "clients")
public interface ClientApi {

    @PostMapping(value = APP_ROOT + "/clients/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un client", notes = "Ajouter/modifier un client dans la BDD", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Client cree / modifier dans la BDD"),
            @ApiResponse(code = 404, message = "Client n'est pas trouve dans la BDD avec l'ID fourni")
    })
    ClientDto save(@RequestBody ClientDto dto);

    @GetMapping(value = APP_ROOT + "/cliens/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un client", notes = "Rechercher client avec l'ID fourni")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client trouvee dans la BDD avec l'ID fourni"),
            @ApiResponse(code = 404, message = "Le client n'est pas trouve dans la BDD avec l'ID fourni", response = ClientDto.class)

    })
    ClientDto findById(@PathVariable("idClient") Integer id);

    @GetMapping(value = APP_ROOT + "/cliens/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un client", notes = "Rechercher client avec le nom fourni", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client trouvee dans la BDD avec le nom fourni"),
            @ApiResponse(code = 404, message = "Le client n'est pas trouve dans la BDD avec le nom fourni")

    })
    ClientDto finbyNom(@PathVariable("nom") String nom);

    @GetMapping(value = APP_ROOT + "/cliens/{prenom}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un client", notes = "Rechercher client avec le prenom fourni", response = ClientDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le client trouvee dans la BDD avec le prenom fourni"),
            @ApiResponse(code = 404, message = "Le client n'est pas trouve dans la BDD avec le prenom fourni")

    })
    ClientDto findByPrenom(@PathVariable("prenom") String prenom);


    @GetMapping(value = APP_ROOT + "/clients/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des clients", notes = "Cette methode permet de rechercher et revoyer la liste des clients dans la BDD", responseContainer = "List<ClientDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des clients/ liste vide"),
    })
    List<ClientDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/clients/delete/{idClient}")
    @ApiOperation(value = "supprimer un client", notes = "Cette methode permet de supprimer un client par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le client a ete supprimer")
    })
    void delete(@PathVariable("idClient") Integer id);
}
