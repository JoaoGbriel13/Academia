package br.com.jg.Academia.Service;

import br.com.jg.Academia.Model.Professor;
import org.springframework.http.ResponseEntity;

public interface ProfessorService {
    ResponseEntity cadastrarProfessor(Professor professor);
}
