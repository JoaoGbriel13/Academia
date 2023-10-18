package br.com.jg.Academia.Service.impl;

import br.com.jg.Academia.Model.Professor;
import br.com.jg.Academia.Repository.ProfessorRepository;
import br.com.jg.Academia.Service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public ResponseEntity cadastrarProfessor(Professor professor) {
        professorRepository.save(professor);
        return ResponseEntity.ok(professor);
    }

}
