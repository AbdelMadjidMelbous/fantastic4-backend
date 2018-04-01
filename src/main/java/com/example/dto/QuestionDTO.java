package com.example.dto;

import com.example.models.Niveau;
import com.example.models.Proposition;
import javax.validation.constraints.NotNull;
import java.util.List;

public class QuestionDTO {

    private Long id;
    @NotNull(message = "NotNull.questionDTO.ennoncé")
    private String ennonce;
    @NotNull(message = "NotNull.questionDTO.poids")
    private int poids;
    @NotNull(message = "NotNull.questionDTO.réponse")
    private String reponse;
    private Niveau niveau;
    private List<Proposition> propositions;

    public QuestionDTO() {
    }

    public QuestionDTO(Long id, @NotNull(message = "NotNull.questionDTO.ennoncé") String ennonce, @NotNull(message = "NotNull.questionDTO.poids") int poids, @NotNull(message = "NotNull.questionDTO.réponse") String reponse) {
        this.id = id;
        this.ennonce = ennonce;
        this.poids = poids;
        this.reponse = reponse;
    }

    public QuestionDTO(Long id, @NotNull(message = "NotNull.questionDTO.ennoncé") String ennonce, @NotNull(message = "NotNull.questionDTO.poids") int poids, @NotNull(message = "NotNull.questionDTO.réponse") String reponse, Niveau niveau, List<Proposition> propositions) {
        this.id = id;
        this.ennonce = ennonce;
        this.poids = poids;
        this.reponse = reponse;
        this.niveau = niveau;
        this.propositions = propositions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnnonce() {
        return ennonce;
    }

    public void setEnnonce(String ennonce) {
        this.ennonce = ennonce;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public List<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(List<Proposition> propositions) {
        this.propositions = propositions;
    }
}
