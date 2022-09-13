package br.com.fiap.epictaskapi.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.epictaskapi.model.Student;
import br.com.fiap.epictaskapi.model.Task;
import br.com.fiap.epictaskapi.model.User;
import br.com.fiap.epictaskapi.repository.StudentRepository;
import br.com.fiap.epictaskapi.repository.TaskRepository;
import br.com.fiap.epictaskapi.repository.UserRepository;

@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        
        // userRepository.save(
        //     new User()
        //         .name("João")
        //         .email("joao@fiap.com.br")
        //         .password(passwordEncoder.encode("123"))
        // );
        userRepository.save(
            new User()
                .name("Admin")
                .email("admin@fiap.com.br")
                .password(passwordEncoder.encode("administrador"))
        );
        studentRepository.saveAll(List.of(
            new Student("Andrey Fernandez","87219"),
            new Student("Bruno de Jesus","87006"),
            new Student("Davi Domingos","87500"),
            new Student("Daniel Bernardo","88532"),
            new Student("Felipe Araujo dos Santos","88753"),
            new Student("João Victor Martins","89087")
        ));
    }
    
}
