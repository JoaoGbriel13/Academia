package br.com.jg.Academia.Service;

import br.com.jg.Academia.Model.Aluno;
import br.com.jg.Academia.Model.Professor;
import org.springframework.http.ResponseEntity;

public interface AlunoService {
    ResponseEntity cadastrarAluno(Aluno aluno);
    ResponseEntity atualizarAluno(long id, Aluno aluno);
    ResponseEntity buscarAlunoId(long id);
    ResponseEntity buscarTodos();
    ResponseEntity buscarPorProfessor(long professorId);
    ResponseEntity deletarAluno(long id);
    ResponseEntity marcarPresenca(long id);
}
