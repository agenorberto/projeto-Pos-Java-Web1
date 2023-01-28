package dev.fujioka.java.avancado.web.dto;


import lombok.Builder;

@Builder
public class ProfessorDTO {
    private String nomeProfessor;
    private String cpf;
    private String email;
    private String telefone;
}
