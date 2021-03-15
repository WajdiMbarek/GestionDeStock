package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.LigneVenteDto;
import com.wajdi.GestionDeStock.dto.VenteDto;
import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Article;
import com.wajdi.GestionDeStock.model.LigneVente;
import com.wajdi.GestionDeStock.model.Vente;
import com.wajdi.GestionDeStock.respository.ArticleRepository;
import com.wajdi.GestionDeStock.respository.LigneVenteRepository;
import com.wajdi.GestionDeStock.respository.VenteRepository;
import com.wajdi.GestionDeStock.services.VenteService;
import com.wajdi.GestionDeStock.validator.VenteValidator;
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
public class VenteServiceImpl implements VenteService {

    private ArticleRepository articleRepository;
    private VenteRepository venteRepository;
    private LigneVenteRepository ligneVenteRepository;

    @Autowired
    public VenteServiceImpl(ArticleRepository articleRepository, VenteRepository venteRepository, LigneVenteRepository ligneVenteRepository) {
        this.articleRepository = articleRepository;
        this.venteRepository = venteRepository;
        this.ligneVenteRepository = ligneVenteRepository;
    }

    @Override
    public VenteDto save(VenteDto dto) {
        List<String> errors = VenteValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("la vente n'est pas valide");
            throw new InvalidEntityException("la vente n'est pas valide", ErrorCodes.VENTE_NOT_VALID, errors);
        }

        List<String> articleErrors = new ArrayList<>();
        dto.getLigneVentes().forEach(ligneVenteDto -> {
            Optional<Article> article = articleRepository.findById(ligneVenteDto.getArticle().getId());
            if (article.isEmpty()) {
                articleErrors.add("Aucun article avec l'Id " + ligneVenteDto.getArticle().getId() + "n'existe dans la BDD");
            }
        });
        if (!articleErrors.isEmpty()) {
            log.error("one or many article was not found in the BDD {}", articleErrors);
            throw new InvalidEntityException("un ou plusieurs article n'est pas trouve dans la BDD", ErrorCodes.VENTE_NOT_VALID, articleErrors);
        }
        Vente savedVente = venteRepository.save(VenteDto.toEntity(dto));

        dto.getLigneVentes().forEach(ligneVenteDto -> {
            LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
            ligneVente.setVente(savedVente);
            ligneVenteRepository.save(ligneVente);
        });

        return VenteDto.fromEntity(savedVente);
    }

    @Override
    public VenteDto findById(Integer id) {
        if (id == null) {
            log.error("Vente id est null");
            return null;
        }

        return venteRepository.findById(id)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Aucune vente n'est trouve dans la BDD avec l'id" + id, ErrorCodes.VENTE_NOT_FOUND);
                });
    }

    @Override
    public VenteDto findByCode(String code) {
        if (!StringUtils.hasLength(code)) {
            log.error("Vente code est null");
            return null;
        }

        return venteRepository.findVenteByCode(code)
                .map(VenteDto::fromEntity)
                .orElseThrow(() -> {
                    throw new EntityNotFoundException("Aucune vente n'est trouve dans la BDD avec le code" + code, ErrorCodes.VENTE_NOT_FOUND);
                });
    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepository.findAll().stream()
                .map(VenteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente id est null");
            return;
        }
        venteRepository.deleteById(id);
    }
}
