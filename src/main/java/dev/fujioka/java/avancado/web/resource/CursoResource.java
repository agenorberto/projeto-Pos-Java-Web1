package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoResource {

    @Autowired
    private CursoService cursoService;

    //Listar Curso
    @GetMapping
    public ResponseEntity<List<Curso>> getCurso(){
        return ResponseEntity.ok(cursoService.listarCurso());
    }

    //Incluir Curso
    @PostMapping
    public ResponseEntity<Curso> salvar(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.salvar(curso));
    }

    //Alterar Curso
    @PutMapping
    public ResponseEntity<Curso> alterar(@RequestBody Curso curso){
        return ResponseEntity.ok(cursoService.alterar(curso));
    }

    //Deletar Curso
    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> deletar(@PathVariable int id){
        cursoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    //Consultar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> consultarPorId(@PathVariable int id){
        return ResponseEntity.ok(cursoService.consultarPorId(id));
    }

}
