package br.com.jg.Academia.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity(name = "tb_aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = false)
    private String Nome;
    @Column(nullable = false)
    private String document;
    private LocalDate dataNascimento;
    private double peso;
    private double altura;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Professor professor;
    private LocalDate ultimoTreino;
    private boolean matriculaAtiva;
    @CreationTimestamp
    private LocalDate dataMatricula;

    public Aluno(Long id, String nome, String document, LocalDate dataNascimento, double peso, double altura, Professor professor, boolean matriculaAtiva, LocalDate dataMatricula) {
        Id = id;
        Nome = nome;
        this.document = document;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
        this.professor = professor;
        this.matriculaAtiva = matriculaAtiva;
        this.dataMatricula = dataMatricula;
    }


    public Aluno() {
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

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public LocalDate getUltimoTreino() {
        return ultimoTreino;
    }

    public void setUltimoTreino(LocalDate ultimoTreino) {
        this.ultimoTreino = ultimoTreino;
    }

    public boolean isMatriculaAtiva() {
        return matriculaAtiva;
    }

    public void setMatriculaAtiva(boolean matriculaAtiva) {
        this.matriculaAtiva = matriculaAtiva;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
