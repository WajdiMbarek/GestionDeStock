package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.ArticleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wajdi.GestionDeStock.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/articles")
public interface ArticleApi {


    @PostMapping(value = APP_ROOT + "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette méthode permet d'enregistrer ou modifier un article", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'objet article cree/ modifier dans la BDD")
    })
    ArticleDto save(@RequestBody ArticleDto dto);

    // recherche avec l' ID de l'article
    @GetMapping(value = APP_ROOT + "/article/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un article ", notes = "cette methode permet de rechercher un article par son ID", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'est trouve dans la BDD avec l'ID fourni ")
    })
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    // recherche avec le code
    @GetMapping(value = APP_ROOT + "/article/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Recherche un article ", notes = "cette methode permet de rechercher un article par son code", response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'article a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucun article n'est trouve dans la BDD avec le code fourni ")
    })
    ArticleDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

    // retourne tout les articles
    @GetMapping(value = APP_ROOT + "/article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoi la liste des articles", notes = "cette methode permet de chercher et renvoyer la liste des article qui existent dans la BDD", responseContainer = "List<ArticleDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "la liste des articles/ liste vide")
    })
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    @ApiOperation(value = "supprimer un article", notes = "Cette methode permet de supprimer un article par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'article a ete supprimer")
    })
    void delete(@PathVariable("idArticle") Integer id);
}
