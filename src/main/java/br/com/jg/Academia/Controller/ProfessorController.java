package br.com.jg.Academia.Controller;

import br.com.jg.Academia.Model.Professor;
import br.com.jg.Academia.Service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academia")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping("/academia/professor")
    public ResponseEntity cadastrarProfessor(@RequestBody Professor professor){
        return professorService.cadastrarProfessor(professor);
    }
}
