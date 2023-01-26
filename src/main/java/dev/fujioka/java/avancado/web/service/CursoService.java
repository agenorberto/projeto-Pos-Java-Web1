package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCurso(){

        return cursoRepository.findAll();
    }

    public Curso salvar(Curso curso){

        return cursoRepository.save(curso);
    }

    public Curso alterar(Curso curso){

        return cursoRepository.save(curso);
    }

    public void excluir(int id){

        cursoRepository.deleteById(id);
    }

    public Curso consultarPorId(int id){
        return cursoRepository.findById(id).orElseThrow();
    }
}
