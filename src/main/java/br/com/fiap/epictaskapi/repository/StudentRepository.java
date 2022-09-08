package br.com.fiap.epictaskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.epictaskapi.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
