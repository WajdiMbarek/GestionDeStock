package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.FournisseurDto;

import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Fournisseur;
import com.wajdi.GestionDeStock.respository.FournisseurRepository;
import com.wajdi.GestionDeStock.services.FournisseurService;
import com.wajdi.GestionDeStock.validator.FournisseurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;

    @Autowired
    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("le fournisseur est invalide");
            throw new InvalidEntityException("le fournisseur est invalide", ErrorCodes.FOURNISSEUR_NOT_VALIDE, errors);
        }
        return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(dto)));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        if (id == null) {
            log.error("l'id est null");
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);

        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException("le fournisseur avec l'id: " + id + "n'est pas trouve dans la BDD", ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public FournisseurDto finbyNom(String nom) {
        if (nom == null) {
            log.error("le nom est null");
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findFournisseurByNom(nom);

        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException("le fournisseur avec le nom: " + nom + "n'est pas trouve dans la BDD", ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public FournisseurDto findByPrenom(String prenom) {
        if (prenom == null) {
            log.error("le nom est null");
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findFournisseurByPrenom(prenom);

        return Optional.of(FournisseurDto.fromEntity(fournisseur.get())).orElseThrow(() ->
                new EntityNotFoundException("le fournisseur avec le nom: " + prenom + "n'est pas trouve dans la BDD", ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("l'id est null");
        }
        fournisseurRepository.deleteById(id);
    }
}
