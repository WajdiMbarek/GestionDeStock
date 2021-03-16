package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wajdi.GestionDeStock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/category/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un categorie", notes = "Ajouter ou modifier un categorie", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet category cree/ modifier dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun objet n'est trouvee avec l'ID fourni"),
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une categorie ", notes = "Cette methode permet de rechercher une categorie avec l'ID founi", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet category aved l'ID fourni est trouvee"),
            @ApiResponse(code = 404, message = "Aucun objet n'est trouvee avec l'ID fourni"),
    })
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping(value = APP_ROOT + "/categories/{codeCategorie}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher une categorie ", notes = "Cette methode permet de rechercher une categorie avec le code categorie founi", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'objet category aved le code fourni est trouvee"),
            @ApiResponse(code = 404, message = "Aucun objet n'est trouvee avec le code fourni"),
    })
    CategoryDto findByCode(@PathVariable("codeCategorie") String code);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des categorie", notes = "Cette methode permet de rechercher et revoyer la liste des categories dans la BDD", responseContainer = "List<CategoryDTO>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des categorie/ liste vide"),
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    @ApiOperation(value = "supprimer une categorie", notes = "supprimer la categorie avec l'ID fourni")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la categorie est supprimer ")
    })
    void delete(@PathVariable("idCategory") Integer id);
}
