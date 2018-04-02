package com.example.service;

import com.example.dto.QuestionDTO;
import com.example.models.Question;
import com.example.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl {
    @Autowired
    private QuestionRepository repository;

    public List<QuestionDTO> findAll() {
        return repository.findAll().stream()
                .map(entity -> new QuestionDTO(entity.getId(), entity.getEnnonce(), entity.getPoids(),entity.getReponse(),entity.getNiveau(),entity.getProposition1(),entity.getProposition2(),entity.getProposition3()))
                .collect(Collectors.toList());
    }

    @Transactional
    public QuestionDTO create(QuestionDTO question) {
        Question newQuestion = new Question();
        newQuestion.setEnnonce(question.getEnnonce());
        newQuestion.setPoids(question.getPoids());
        newQuestion.setReponse(question.getReponse());
        newQuestion.setNiveau(question.getNiveau());
        newQuestion.setProposition1(question.getProposition1());
        newQuestion.setProposition2(question.getProposition2());
        newQuestion.setProposition3(question.getProposition3());
        Question savedQuestion = repository.saveAndFlush(newQuestion);
        return new QuestionDTO(savedQuestion.getId(), savedQuestion.getEnnonce(), savedQuestion.getPoids(),savedQuestion.getReponse(),savedQuestion.getNiveau(),savedQuestion.getProposition1(),savedQuestion.getProposition2(),savedQuestion.getProposition3());
    }

    @Transactional
    public QuestionDTO update(Long id, QuestionDTO question) {
        Question entity = findOneSafe(id);
        entity.setEnnonce(question.getEnnonce());
        entity.setPoids(question.getPoids());
        entity.setReponse(question.getReponse());
        entity.setNiveau(question.getNiveau());
        entity.setProposition1(question.getProposition1());
        entity.setProposition2(question.getProposition2());
        entity.setProposition3(question.getProposition3());
        return new QuestionDTO(entity.getId(), entity.getEnnonce(), entity.getPoids(),entity.getReponse(),entity.getNiveau(),entity.getProposition1(),entity.getProposition2(),entity.getProposition3());
    }

    @Transactional
    public void delete(Long id) {
        Question question = findOneSafe(id);
        repository.delete(question);
    }

    @Transactional
    public Question findOneSafe(Long id) {
        Question question = repository.getOne(id);
        if (question == null) {
            throw new QuestionNotFoundException();
        } else {
            return question;
        }
    }
    @Transactional
    public QuestionDTO questionToDto(Question question) {
        if (question == null) {
            throw new QuestionNotFoundException();
        } else {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO .setId(question.getId());
            questionDTO .setEnnonce(question.getEnnonce());
            questionDTO .setPoids(question.getPoids());
            questionDTO .setNiveau(question.getNiveau());
            questionDTO.setProposition1(question.getProposition1());
            questionDTO.setProposition2(question.getProposition2());
            questionDTO.setProposition3(question.getProposition3());
            return questionDTO ;
        }
    }
}
