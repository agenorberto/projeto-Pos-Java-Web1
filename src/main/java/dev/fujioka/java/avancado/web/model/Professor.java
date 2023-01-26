package dev.fujioka.java.avancado.web.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.time.Instant;

@Getter
@Setter
@Entity
@Data
@Email
public class Professor {

    @Id
    @GeneratedValue
    private Integer id;
    private String nomeProfessor;
    private String cpf;
    private Instant dataNascimento;
    private String sexo;
    private String email;
    private String telefone;


}
