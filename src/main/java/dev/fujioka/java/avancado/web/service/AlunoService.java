package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.model.Aluno;
import dev.fujioka.java.avancado.web.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    //Listar Alunos
    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    //Incluir Aluno
    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    //Alterar Alunos
    public Aluno alterar(Aluno aluno){
        if(Objects.isNull(aluno.getId())) {
            throw new RuntimeException("ID não preenchido");
        }
        return alunoRepository.save(aluno);
    }

    //Deletar Alunos
    public void excluir(int id){
        alunoRepository.deleteById(id);
    }

    public Aluno consultarPorId(int id){

        return alunoRepository.findById(id).orElseThrow();
    }

    public List<Aluno> buscarAlunoLike(String nome){
        return alunoRepository.buscarAlunoPorNomeLike(nome);
    }

    public Aluno buscarAlunoPorMatricula(String matricula){
        return alunoRepository.findByMatricula(matricula);
    }

    public Aluno buscarAlunoPorMatriculaNome(String matricula, String nome){
        return alunoRepository.findByMatriculaAndNome(matricula, nome);
    }

}
