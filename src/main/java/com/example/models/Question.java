package com.example.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable=false)
    private String ennonce;
    @Column(nullable=false)
    private int poids;
    @Column(nullable=false)
    private String reponse;


    @ManyToOne
    @JoinColumn(name="niveau_id")
    private Niveau niveau;

    @ManyToMany(mappedBy = "questions")
    private List<Proposition> propositions;

    public Question() {
    }

    public Question(String ennonce, int poids, String reponse) {
        this.ennonce = ennonce;
        this.poids = poids;
        this.reponse = reponse;
    }

    public Question(String ennonce, int poids, String reponse, Niveau niveau, List<Proposition> propositions) {
        this.ennonce = ennonce;
        this.poids = poids;
        this.reponse = reponse;
        this.niveau = niveau;
        this.propositions = propositions;
    }

    public Long getId() {
        return id;
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
