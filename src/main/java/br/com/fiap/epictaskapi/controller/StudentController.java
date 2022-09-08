package br.com.fiap.epictaskapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.epictaskapi.model.Student;
import br.com.fiap.epictaskapi.service.StudentService;

@RestController
@RequestMapping("/api/grupo")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping
    public Page<Student> index( @PageableDefault(size = 10, sort = "name") Pageable pageable){
        return service.listAll(pageable);
    }
}
