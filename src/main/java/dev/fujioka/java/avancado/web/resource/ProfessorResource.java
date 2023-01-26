package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    @Autowired
    private ProfessorService professorService;

    //Listar Professores
    @GetMapping
    public ResponseEntity<List<Professor>> getProfessor(){
        return ResponseEntity.ok(professorService.listarProfessor());
    }

    //Salvar Professor
    @PostMapping
    public ResponseEntity<Professor> salvar(@RequestBody Professor professor){
        return ResponseEntity.ok(professorService.salvar(professor));
    }

    //Alterar Professor
    @PutMapping
    public ResponseEntity<Professor> alterar(@RequestBody Professor professor){
        return ResponseEntity.ok(professorService.alterar(professor));
    }

    //Excluir Professor
    @DeleteMapping("/{id}")
    public ResponseEntity<Professor> deletar(@PathVariable int id){
        professorService.excluir(id);
        return ResponseEntity.ok().build();
    }

    //Listar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Professor> consultarPorId(@PathVariable int id){
        return ResponseEntity.ok(professorService.consultarPorId(id));
    }
}
