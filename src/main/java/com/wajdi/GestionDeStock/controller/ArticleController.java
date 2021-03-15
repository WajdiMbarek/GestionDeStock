package com.wajdi.GestionDeStock.controller;

import com.wajdi.GestionDeStock.controller.api.ArticleApi;
import com.wajdi.GestionDeStock.dto.ArticleDto;
import com.wajdi.GestionDeStock.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ArticleController implements ArticleApi {

    private ArticleService articleService;

    @Autowired
    public ArticleController(
            ArticleService articleService
    ){
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}
