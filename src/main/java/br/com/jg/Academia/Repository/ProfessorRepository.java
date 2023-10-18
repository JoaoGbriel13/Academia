package br.com.jg.Academia.Repository;

import br.com.jg.Academia.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
