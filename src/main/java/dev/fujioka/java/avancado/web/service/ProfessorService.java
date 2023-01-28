package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.ProfessorDTO;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> listarProfessor(){
        return professorRepository.findAll();
    }

    @Autowired
    private JmsTemplate jmsTemplate;

    public ProfessorDTO salvar(Professor professor){

        professor = professorRepository.save(professor);
        jmsTemplate.convertAndSend("matricula_professor_queue", professor);

        return ProfessorDTO.builder()
                .nomeProfessor(professor.getNomeProfessor())
                .cpf(professor.getCpf())
                .email(professor.getEmail())
                .telefone(professor.getTelefone())
                .build();
    }

    public Professor alterar(Professor professor){

        return professorRepository.save(professor);
    }

    public void excluir(int id){

        professorRepository.deleteById(id);
    }

    public Professor consultarPorId(int id){
        return professorRepository.findById(id).orElseThrow();
    }
}
