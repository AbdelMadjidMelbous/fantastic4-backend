package com.example.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Propositions")
public class Proposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(nullable=false)
    private String contenu;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "proposition_question",
            joinColumns = @JoinColumn(name = "question_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "proposition_id",
                    referencedColumnName = "id"))
    private List<Question> questions;

    public Proposition() {
    }

    public Proposition(String contenu) {
        this.contenu = contenu;
    }

    public Proposition(String contenu, List<Question> questions) {
        this.contenu = contenu;
        this.questions = questions;
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
