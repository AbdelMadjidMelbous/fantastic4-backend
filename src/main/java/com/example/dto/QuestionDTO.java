package com.example.dto;

import com.example.models.Niveau;

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
    private String proposition1;
    private String proposition2;
    private String proposition3;

    public QuestionDTO() {
    }

    public QuestionDTO(Long id, @NotNull(message = "NotNull.questionDTO.ennoncé") String ennonce, @NotNull(message = "NotNull.questionDTO.poids") int poids, @NotNull(message = "NotNull.questionDTO.réponse") String reponse) {
        this.id = id;
        this.ennonce = ennonce;
        this.poids = poids;
        this.reponse = reponse;
    }

    public QuestionDTO(Long id, @NotNull(message = "NotNull.questionDTO.ennoncé") String ennonce, @NotNull(message = "NotNull.questionDTO.poids") int poids, @NotNull(message = "NotNull.questionDTO.réponse") String reponse, Niveau niveau,String proposition1,String proposition2,String proposition3) {
        this.id = id;
        this.ennonce = ennonce;
        this.poids = poids;
        this.reponse = reponse;
        this.niveau = niveau;
        this.proposition1=proposition1;
        this.proposition2=proposition2;
        this.proposition3=proposition3;
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

    public String getProposition1() {
        return proposition1;
    }

    public void setProposition1(String proposition1) {
        this.proposition1 = proposition1;
    }

    public String getProposition2() {
        return proposition2;
    }

    public void setProposition2(String proposition2) {
        this.proposition2 = proposition2;
    }

    public String getProposition3() {
        return proposition3;
    }

    public void setProposition3(String proposition3) {
        this.proposition3 = proposition3;
    }
}
