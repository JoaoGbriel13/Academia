package br.com.jg.Academia.Service.impl;

import br.com.jg.Academia.Model.Aluno;
import br.com.jg.Academia.Repository.AlunoRepository;
import br.com.jg.Academia.Service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public ResponseEntity cadastrarAluno(Aluno aluno) {
        if (alunoRepository.existsBydocument(aluno.getDocument())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O aluno já está cadastrado");
        }
        alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Aluno cadastrado" + aluno);
    }

    @Override
    public ResponseEntity atualizarAluno(long id, Aluno aluno) {
        if (!alunoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        aluno.setId(id);
        alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Aluno atualizado" + aluno);
    }

    @Override
    public ResponseEntity buscarAlunoId(long id) {
        if (!alunoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        var searchAluno = alunoRepository.findById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(searchAluno);
    }

    @Override
    public ResponseEntity buscarTodos() {
        return ResponseEntity.status(HttpStatus.FOUND).body(alunoRepository.findAll());
    }

    @Override
    public ResponseEntity buscarPorProfessor(long professorId) {
        return ResponseEntity.ok(alunoRepository.findAllByprofessorId(professorId));
    }

    @Override
    public ResponseEntity deletarAluno(long id) {
        if (!alunoRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
        }
        alunoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Aluno removido");
    }

    @Override
    public ResponseEntity marcarPresenca(long id) {
        var alunoEncontrado = alunoRepository.findById(id).orElseThrow(RuntimeException::new);
        alunoEncontrado.setUltimoTreino(LocalDate.now());
        alunoEncontrado.setId(id);
        return ResponseEntity.ok(alunoRepository.save(alunoEncontrado));
    }
}
