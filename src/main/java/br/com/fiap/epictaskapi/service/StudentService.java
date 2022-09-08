package br.com.fiap.epictaskapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.epictaskapi.model.Student;
import br.com.fiap.epictaskapi.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public Page<Student> listAll(Pageable pageable){
        return repository.findAll(pageable);
     }
 
     public void save(Student student) {
         repository.save(student);
     }
 
     public Optional<Student> getById(Long id) {
         return repository.findById(id);
     }
 
     public void deleteById(Long id) {
         repository.deleteById(id);
     }
    
 
}
