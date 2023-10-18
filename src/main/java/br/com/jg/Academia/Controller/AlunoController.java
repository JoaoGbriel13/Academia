package br.com.jg.Academia.Controller;

import br.com.jg.Academia.Model.Aluno;
import br.com.jg.Academia.Model.Professor;
import br.com.jg.Academia.Service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/academia")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
    @GetMapping
    public ResponseEntity getAllAlunos(){
        return alunoService.buscarTodos();
    }
    @GetMapping("/aluno/{id}")
    public ResponseEntity getAlunoById(@PathVariable("id") long id){
        return alunoService.buscarAlunoId(id);
    }
    @GetMapping("/getByProfessor/{id}")
    public ResponseEntity getAlunoByProfessor(@PathVariable long id){
        return alunoService.buscarPorProfessor(id);
    }
    @PostMapping
    public ResponseEntity cadastrarAluno(@RequestBody Aluno aluno){
        return alunoService.cadastrarAluno(aluno);
    }
    @PutMapping("/{id}")
    public ResponseEntity atualizarAluno(@RequestBody Aluno aluno, @PathVariable("id") long id){
        return alunoService.atualizarAluno(id,aluno);
    }
    @PutMapping("/presenca/{id}")
    public ResponseEntity atualizarPresenca(@PathVariable("id") long id){
        return alunoService.marcarPresenca(id);
    }
}
