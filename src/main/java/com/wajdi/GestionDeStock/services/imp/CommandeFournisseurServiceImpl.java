package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.CommandeFournisseurDto;
import com.wajdi.GestionDeStock.dto.LigneCommandeFournisseurDto;
import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Article;
import com.wajdi.GestionDeStock.model.CommandeFournisseur;
import com.wajdi.GestionDeStock.model.Fournisseur;
import com.wajdi.GestionDeStock.model.LigneCommandeFournisseur;
import com.wajdi.GestionDeStock.respository.ArticleRepository;
import com.wajdi.GestionDeStock.respository.CommandeFournisseurRepository;
import com.wajdi.GestionDeStock.respository.FournisseurRepository;
import com.wajdi.GestionDeStock.respository.LigneCommandeFournisseurRepository;
import com.wajdi.GestionDeStock.services.CommandeFournisseurService;
import com.wajdi.GestionDeStock.validator.CommandeFournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private CommandeFournisseurRepository commandeFournisseurRepository;
    private FournisseurRepository fournisseurRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;

    @Autowired
    public CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFournisseurRepository, FournisseurRepository fournisseurRepository, ArticleRepository articleRepository, LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository) {
        this.commandeFournisseurRepository = commandeFournisseurRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeFournisseurRepository = ligneCommandeFournisseurRepository;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("le commande fournisseur n'est pas valide");
            throw new InvalidEntityException("la commande fournisseur n'est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_VALID, errors);
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(dto.getFournisseur().getId());
        if (fournisseur.isEmpty()) {
            log.warn("Fournisseur with ID {} was not found in the BD", dto.getFournisseur().getId());
            throw new EntityNotFoundException("Aucun fournisseur avec l'ID:" + dto.getFournisseur().getId() + "n'a ete trouve dans la BDD", ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();
        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdClt -> {
                if (ligCmdClt.getArticle() != null) {
                    Optional<Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
                    if (article.isEmpty()) {
                        articleErrors.add("l'article avec l'ID " + ligCmdClt.getArticle().getId() + "n'existe pas dans la BDD");
                    }
                } else {
                    articleErrors.add("Impossible d'enregister une commande avec un article null");
                }
            });
        }
        if (!articleErrors.isEmpty()) {
            log.warn("");
            throw new InvalidEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }

        CommandeFournisseur saveCmdFrnsr = commandeFournisseurRepository.save(CommandeFournisseurDto.toEntity(dto));
        if (dto.getLigneCommandeFournisseurs() != null) {
            dto.getLigneCommandeFournisseurs().forEach(ligCmdFrnsr -> {
                LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdFrnsr);
                ligneCommandeFournisseur.setCommandeFournisseur(saveCmdFrnsr);
                ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
            });
        }
        return CommandeFournisseurDto.fromEntity(saveCmdFrnsr);
    }

    @Override
    public CommandeFournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("l'ID est null");
        }
        Optional<CommandeFournisseur> commandeFournisseur = commandeFournisseurRepository.findById(id);

        return Optional.of(CommandeFournisseurDto.fromEntity(commandeFournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException("la commande fournisseur avec l'ID: " + id + "n'est pas trouve dans la BDD", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("le code de la commande est null");
        }
        return commandeFournisseurRepository.findCommandeFournisseurByCode(code)
                .map(CommandeFournisseurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("la commande fournisseur avec le code :" + code + "n'est pas trouve", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
    }

    @Override
    public List<CommandeFournisseurDto> findAll() {
        return commandeFournisseurRepository.findAll().stream()
                .map(CommandeFournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("l'ID est null");
            return;
        }
        commandeFournisseurRepository.deleteById(id);
    }

}
