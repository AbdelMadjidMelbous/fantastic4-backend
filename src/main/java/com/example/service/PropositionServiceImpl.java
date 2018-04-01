package com.example.service;

import com.example.dto.PropositionDTO;
import com.example.models.Proposition;
import com.example.repository.PropositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropositionServiceImpl {

    @Autowired
    private PropositionRepository repository;

    public List<PropositionDTO> findAll() {
        return repository.findAll().stream()
                .map(entity -> new PropositionDTO(entity.getId(), entity.getContenu()))
                .collect(Collectors.toList());
    }

    @Transactional
    public PropositionDTO create(PropositionDTO proposition) {
        Proposition newProposition = new Proposition();
        newProposition.setContenu(proposition.getContenu());
        newProposition.setQuestions(proposition.getQuestions());
        Proposition savedProposition = repository.saveAndFlush(newProposition);
        return new PropositionDTO(savedProposition.getId(), savedProposition.getContenu(),savedProposition.getQuestions());
    }

    @Transactional
    public PropositionDTO update(Long id, PropositionDTO proposition) {
        Proposition entity = findOneSafe(id);
        entity.setContenu(proposition.getContenu());
        entity.setQuestions(proposition.getQuestions());
        return new PropositionDTO(entity.getId(), entity.getContenu(), entity.getQuestions());
    }

    @Transactional
    public void delete(Long id) {
        Proposition proposition = findOneSafe(id);
        repository.delete(proposition);
    }

    @Transactional
    public Proposition findOneSafe(Long id) {
        Proposition proposition = repository.getOne(id);
        if (proposition == null) {
            throw new QuestionNotFoundException();
        } else {
            return proposition;
        }
    }

    @Transactional
    public PropositionDTO propositionToDto(Proposition proposition) {
        if (proposition == null) {
            throw new QuestionNotFoundException();
        } else {
            PropositionDTO propositionDTO = new PropositionDTO();
            propositionDTO .setId(proposition.getId());
            propositionDTO .setContenu(proposition.getContenu());
            propositionDTO .setQuestions(proposition.getQuestions());
            return propositionDTO ;
        }
    }
}

