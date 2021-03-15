package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.CommandeClientDto;
import com.wajdi.GestionDeStock.dto.LigneCommandeClientDto;
import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Article;
import com.wajdi.GestionDeStock.model.Client;
import com.wajdi.GestionDeStock.model.CommandeClient;
import com.wajdi.GestionDeStock.model.LigneCommandeClient;
import com.wajdi.GestionDeStock.respository.ArticleRepository;
import com.wajdi.GestionDeStock.respository.ClientRepository;
import com.wajdi.GestionDeStock.respository.CommandeClientRepository;
import com.wajdi.GestionDeStock.respository.LigneCommandeClientRepository;
import com.wajdi.GestionDeStock.services.CommandeClientService;
import com.wajdi.GestionDeStock.validator.CommandeClientValidator;
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
public class CommandeClientServiceImpl implements CommandeClientService {

    private CommandeClientRepository commandeClientRepository;
    private ClientRepository clientRepository;
    private ArticleRepository articleRepository;
    private LigneCommandeClientRepository ligneCommandeClientRepository;

    @Autowired
    public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository, ClientRepository clientRepository, ArticleRepository articleRepository, LigneCommandeClientRepository ligneCommandeClientRepository) {
        this.commandeClientRepository = commandeClientRepository;
        this.clientRepository = clientRepository;
        this.articleRepository = articleRepository;
        this.ligneCommandeClientRepository = ligneCommandeClientRepository;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("le commande Client n'est pas valide");
            throw new InvalidEntityException("la commande Client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
        }
        Optional<Client> client = clientRepository.findById(dto.getClient().getId());
        if (client.isEmpty()) {
            log.warn("CLient with ID {} was not found in the BD", dto.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID:" + dto.getClient().getId() + "n'a ete trouve dans la BDD", ErrorCodes.CLIENT_NOT_FOUND);
        }

        List<String> articleErrors = new ArrayList<>();
        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
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

        CommandeClient saveCmdClt = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
        if (dto.getLigneCommandeClients() != null) {
            dto.getLigneCommandeClients().forEach(ligCmdClt -> {
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
                ligneCommandeClient.setCommandeClient(saveCmdClt);
                ligneCommandeClientRepository.save(ligneCommandeClient);
            });
        }
        return CommandeClientDto.fromEntity(saveCmdClt);
    }

    @Override
    public CommandeClientDto findById(Integer id) {
        if (id == null) {
            log.error("l'ID est null");
        }
        Optional<CommandeClient> commandeClient = commandeClientRepository.findById(id);

        return Optional.of(CommandeClientDto.fromEntity(commandeClient.get())).orElseThrow(() ->
                new EntityNotFoundException("la commande CLient avec l'ID: " + id + "n'est pas trouve dans la BDD", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND)
        );
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("le code de la commande est null");
        }
        return commandeClientRepository.findByCommandeClientByCode(code)
                .map(CommandeClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("la commande client avec le code :" + code + "n'est pas trouve", ErrorCodes.COMMANDE_CLIENT_NOT_FOUND));
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientRepository.findAll().stream()
                .map(CommandeClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("l'ID est null");
            return;
        }
        commandeClientRepository.deleteById(id);
    }
}
