package br.com.jg.Academia.Model;

import jakarta.persistence.*;

@Entity(name = "tb_professor")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nome;

    public Professor(Long id, String nome) {
        Id = id;
        Nome = nome;
    }

    public Professor() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
