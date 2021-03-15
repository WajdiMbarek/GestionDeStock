package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.UtilisateurDto;
import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Utilisateur;
import com.wajdi.GestionDeStock.respository.UtilisateurRepository;
import com.wajdi.GestionDeStock.services.UtilisateurService;
import com.wajdi.GestionDeStock.validator.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("l'utilisateur est invalide");
            throw new InvalidEntityException("l'utilisateur est invalide", ErrorCodes.UTILISATEUR_NOT_VALIDE, errors);
        }
        return UtilisateurDto.fromEntity(utilisateurRepository.save(UtilisateurDto.toEntity(dto)));
    }

    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("l'id est null");
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() ->
                new EntityNotFoundException("l'utilisateur avec l'id: " + id + "n'est pas trouve dans la BDD", ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public UtilisateurDto finbyNom(String nom) {
        if (nom == null) {
            log.error("le nom est null");
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByNom(nom);

        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() ->
                new EntityNotFoundException("l'utilisateur avec le nom: " + nom + "n'est pas trouve dans la BDD", ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public UtilisateurDto findByPrenom(String prenom) {
        if (prenom == null) {
            log.error("le nom est null");
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByPrenom(prenom);

        return Optional.of(UtilisateurDto.fromEntity(utilisateur.get())).orElseThrow(() ->
                new EntityNotFoundException("l'utilisateur avec le nom: " + prenom + "n'est pas trouve dans la BDD", ErrorCodes.UTILISATEUR_NOT_FOUND)
        );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("l'id est null");
            return;
        }
        utilisateurRepository.deleteById(id);
    }
}
