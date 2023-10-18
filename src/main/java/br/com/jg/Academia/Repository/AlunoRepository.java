package br.com.jg.Academia.Repository;

import br.com.jg.Academia.Model.Aluno;
import br.com.jg.Academia.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno,Long> {
    boolean existsBydocument(String document);
    List<Aluno> findAllByprofessorId(long id);
}
