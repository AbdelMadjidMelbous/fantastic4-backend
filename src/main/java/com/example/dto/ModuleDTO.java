package com.example.dto;

import com.example.models.Niveau;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ModuleDTO {
    private Long id;
    @NotNull(message = "NotNull.moduleDTO.libellé")
    private String libelle;
    private List<Niveau> niveaux;


    public ModuleDTO() {
    }

    public ModuleDTO(Long id, @NotNull(message = "NotNull.moduleDTO.libellé") String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public ModuleDTO(Long id, @NotNull(message = "NotNull.moduleDTO.libellé") String libelle, List<Niveau> niveaux) {
        this.id = id;
        this.libelle = libelle;
        this.niveaux = niveaux;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Niveau> getNiveaux() {
        return niveaux;
    }

    public void setNiveaux(List<Niveau> niveaux) {
        this.niveaux = niveaux;
    }
}
