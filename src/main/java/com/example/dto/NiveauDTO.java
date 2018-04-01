package com.example.dto;

import com.example.dto.ModuleDTO;
import com.example.models.Module;
import com.example.models.Question;
import javax.validation.constraints.NotNull;
import java.util.List;

public class NiveauDTO {

    private Long id;
    @NotNull(message = "NotNull.niveauDTO.libellé")
    private String libelle;
    @NotNull(message = "NotNull.niveauDTO.poids")
    private int poids;
    private Module module;
    private List<Question> questions;

    public NiveauDTO() {
    }

    public NiveauDTO(Long id, @NotNull(message = "NotNull.niveauDTO.libellé") String libelle, @NotNull(message = "NotNull.moduleDTO.poids") int poids) {
        this.id = id;
        this.libelle = libelle;
        this.poids = poids;
    }

    public NiveauDTO(Long id, @NotNull(message = "NotNull.niveauDTO.libellé") String libelle, @NotNull(message = "NotNull.moduleDTO.poids") int poids, Module module, List<Question> questions) {
        this.id = id;
        this.libelle = libelle;
        this.poids = poids;
        this.module = module;
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
