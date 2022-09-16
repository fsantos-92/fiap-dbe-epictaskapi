package br.com.fiap.epictaskapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Paciente {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "cd_paciente", precision = 0, scale = 9)
    private long id;

    @NotNull
    @Column(name = "nm_paciente", length = 80)
    private String nome;

    @Column(name = "nr_cpf", length = 11/*, unique = true*/)
    private String cpf;

    @NotNull
    @Column(name = "dt_nascimento")
	private LocalDate dataNascimento;

    @Column(name = "dt_cadastro")
	private LocalDate dataCadastro;
    
    public Paciente() {
    }

    public Paciente(@NotNull String nome, String cpf, @NotNull LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
       
    @Override
    public String toString() {
        return "Paciente [cpf=" + cpf + ", dataCadastro=" + dataCadastro + ", dataNascimento=" + dataNascimento
                + ", id=" + id + ", nome=" + nome + "]";
    }
}
