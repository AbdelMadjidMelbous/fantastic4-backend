package com.example.service;

import com.example.dto.NiveauDTO;
import com.example.models.Niveau;
import com.example.repository.NiveauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class NiveauServiceImpl {
    @Autowired
    private NiveauRepository repository;

    public List<NiveauDTO> findAll() {
        return repository.findAll().stream()
                .map(entity -> new NiveauDTO(entity.getId(), entity.getLibelle(), entity.getPoids(),entity.getModule(),entity.getQuestions()))
                .collect(Collectors.toList());
    }

    @Transactional
    public NiveauDTO create(NiveauDTO niveau) {
        Niveau newNiveau = new Niveau();
        newNiveau.setLibelle(niveau.getLibelle());
        newNiveau.setPoids(niveau.getPoids());
        newNiveau.setModule(niveau.getModule());
        newNiveau.setQuestions(niveau.getQuestions());
        Niveau savedNiveau = repository.saveAndFlush(newNiveau);
        return new NiveauDTO(savedNiveau.getId(), savedNiveau.getLibelle(), savedNiveau.getPoids(),savedNiveau.getModule(),savedNiveau.getQuestions());
    }

    @Transactional
    public NiveauDTO update(Long id, NiveauDTO niveau) {
        Niveau entity = findOneSafe(id);
        entity.setLibelle(niveau.getLibelle());
        entity.setPoids(niveau.getPoids());
        entity.setModule(niveau.getModule());
        entity.setQuestions(niveau.getQuestions());
        return new NiveauDTO(entity.getId(), entity.getLibelle(), entity.getPoids(),entity.getModule(),entity.getQuestions());
    }

    @Transactional
    public void delete(Long id) {
        Niveau niveau = findOneSafe(id);
        repository.delete(niveau);
    }

    @Transactional
    public Niveau findOneSafe(Long id) {
        Niveau niveau = repository.getOne(id);
        if (niveau == null) {
            throw new QuestionNotFoundException();
        } else {
            return niveau;
        }
    }

    @Transactional
    public NiveauDTO niveauToDto(Niveau niveau) {
        if (niveau == null) {
            throw new QuestionNotFoundException();
        } else {
            NiveauDTO niveauDTO = new NiveauDTO();
            niveauDTO .setId(niveau.getId());
            niveauDTO .setLibelle(niveau.getLibelle());
            niveauDTO .setPoids(niveau.getPoids());
            niveauDTO .setQuestions(niveau.getQuestions());
            return niveauDTO ;
        }
    }

}
