package com.wajdi.GestionDeStock.controller.api;

import com.wajdi.GestionDeStock.dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.wajdi.GestionDeStock.utils.Constants.APP_ROOT;

public interface ArticleApi {

    // Enregistrer ou modifier un article
    @PostMapping(value = APP_ROOT+"/article/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);

    // recherche avec l' ID de l'article
    @GetMapping(value = APP_ROOT+"/article/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable("idArticle") Integer id);

    // recherche avec le code
    @GetMapping(value = APP_ROOT+"/article/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable("codeArticle")String codeArticle);

    // retourne tout les articles
    @GetMapping(value = APP_ROOT+"/article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = APP_ROOT+ "/articles/delete/{idArticle}")
    void delete(@PathVariable("idArticle")Integer id);
}
