package com.wajdi.GestionDeStock.services;

import com.wajdi.GestionDeStock.dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    /*
     * Enregistrer ou modifier un article
     */
    ArticleDto save(ArticleDto dto);

    /*
     * recherche avec l' ID de l'article

     */
    ArticleDto findById(Integer id);

    /*
        // recherche avec le code

     */
    ArticleDto findByCodeArticle(String codeArticle);

    // retourne tout les articles
    List<ArticleDto> findAll();

    void delete(Integer id);
}
