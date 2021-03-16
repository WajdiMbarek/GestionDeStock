package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.EntrepriseDto;
import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Entreprise;
import com.wajdi.GestionDeStock.respository.EntrepriseRepository;
import com.wajdi.GestionDeStock.services.EntrepriseService;
import com.wajdi.GestionDeStock.validator.EntrepriseValidator;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;

    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("l'entreprise n'est pas valide");
            throw new InvalidEntityException("l'entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALIDE, errors);
        }

        return EntrepriseDto.fromEntity(entrepriseRepository.save(EntrepriseDto.toEntity(dto)));
    }

    @Override
    public EntrepriseDto findbyId(Integer id) {
        if (id == null) {
            log.error("l'id est null");
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

        return Optional.of(EntrepriseDto.fromEntity(entreprise.get())).orElseThrow(() ->
                new EntityNotFoundException("l'entreprise avec l'id :" + id + " n'est pas trouve dans la BDD", ErrorCodes.ENTREPRISE_NOT_FOUND)
        );
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseRepository.findAll().stream()
                .map(EntrepriseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("l'id est null");
            return;
        }
        entrepriseRepository.deleteById(id);
    }
}
