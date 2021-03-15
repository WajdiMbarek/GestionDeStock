package com.wajdi.GestionDeStock.services.imp;

import com.wajdi.GestionDeStock.dto.ClientDto;
import com.wajdi.GestionDeStock.exception.EntityNotFoundException;
import com.wajdi.GestionDeStock.exception.ErrorCodes;
import com.wajdi.GestionDeStock.exception.InvalidEntityException;
import com.wajdi.GestionDeStock.model.Client;
import com.wajdi.GestionDeStock.respository.ClientRepository;
import com.wajdi.GestionDeStock.services.ClientService;
import com.wajdi.GestionDeStock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto dto) {
        List<String> errors = ClientValidator.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Le client n'est pas valid");
            throw new InvalidEntityException("Le client n'est pas valide", ErrorCodes.CLIENT_NOT_VALID, errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if (id == null) {
            log.error("l'id est null");
        }
        Optional<Client> client = clientRepository.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("Le client avec l'id: " + id + "n'est pas trouve dans la BDD", ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public ClientDto finbyNom(String nom) {
        if (nom == null) {
            log.error("le nom est null");
        }
        Optional<Client> client = clientRepository.findClientByNom(nom);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("Le client avec le nom: " + nom + "n'est pas trouve dans la BDD", ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public ClientDto findByPrenom(String prenom) {
        if (prenom == null) {
            log.error("le prenom est null");
        }
        Optional<Client> client = clientRepository.findClientByPrenom(prenom);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("Le client avec le prenom: " + prenom + "n'est pas trouve dans la BDD", ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("l'id est null");
            return;
        }
        clientRepository.deleteById(id);
    }
}
