package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.ArticleDto;
import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Article;
import com.wajdi.GestionDeStock.respository.ArticleRepository;
import com.wajdi.GestionDeStock.services.ArticleService;
import com.wajdi.GestionDeStock.validator.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl( ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }
    @Override
    public ArticleDto save(ArticleDto dto) {
        List<String> errors = ArticleValidator.validate(dto);

        if(!errors.isEmpty()){
            log.error("Article is not valid {}",dto);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_FOUND,errors);
        }
        return ArticleDto.fromEntity(
                articleRepository.save(ArticleDto.toEntity(dto))
        );
    }

    @Override
    public ArticleDto findById(Integer id) {
        if(id == null){
            log.error("l'id est null");
        }
        Optional<Article> article = articleRepository.findById(id);
        ArticleDto dto = ArticleDto.fromEntity(article.get());
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID"+ id +" n'ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND
                ));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        if(!StringUtils.hasLength(codeArticle)){
            log.error("l'id est null");
        }
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        ArticleDto dto = ArticleDto.fromEntity(article.get());
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun article avec l'ID"+ codeArticle +" n'ete trouve dans la BDD",
                        ErrorCodes.ARTICLE_NOT_FOUND
                ));    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if(id == null){
            log.error("l'id est null");
            return;
        }
        articleRepository.deleteById(id);
    }
}
