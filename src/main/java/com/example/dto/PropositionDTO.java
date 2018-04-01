package com.example.dto;

import com.example.models.Question;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PropositionDTO {

    private Long id;
    @NotNull(message = "NotNull.propostionDTO.contenu")
    private String contenu;
    private List<Question> questions;

    public PropositionDTO() {
    }

    public PropositionDTO(Long id, @NotNull(message = "NotNull.propostionDTO.contenu") String contenu) {
        this.id = id;
        this.contenu = contenu;
    }

    public PropositionDTO(Long id, @NotNull(message = "NotNull.propostionDTO.contenu") String contenu, List<Question> questions) {
        this.id = id;
        this.contenu = contenu;
        this.questions = questions;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {

        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
