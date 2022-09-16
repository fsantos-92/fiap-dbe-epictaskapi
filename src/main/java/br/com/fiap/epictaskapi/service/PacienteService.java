package br.com.fiap.epictaskapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.fiap.epictaskapi.model.Paciente;
import br.com.fiap.epictaskapi.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;

    public Page<Paciente> listAll(Pageable pageable){
        return repository.findAll(pageable);
     }
 
     public void save(Paciente paciente) {
         repository.save(paciente);
     }
 
     public Optional<Paciente> getById(Long id) {
         return repository.findById(id);
     }
 
     public void deleteById(Long id) {
         repository.deleteById(id);
     }
}
