package br.com.fiap.epictaskapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @JsonIgnore
    private Long id;
    private String name;
    private String rm;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRm() {
        return rm;
    }
    public void setRm(String rm) {
        this.rm = rm;
    }
    public Student() {
    }
    
    
    public Student(String name, String rm) {
        this.name = name;
        this.rm = rm;
    }
    @Override
    public String toString() {
        return "Nome: " + name + ", rm: " + rm;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
}
