package br.com.fiap.epictaskapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.epictaskapi.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
