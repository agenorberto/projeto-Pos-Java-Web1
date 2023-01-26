package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Aluno;
import dev.fujioka.java.avancado.web.repository.AlunoRepository;
import dev.fujioka.java.avancado.web.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos(){

        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @PostMapping
    public ResponseEntity<Aluno> salvar(@RequestBody Aluno aluno){
        return ResponseEntity.ok(alunoService.salvar(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> alterar(@RequestBody Aluno aluno){
        return ResponseEntity.ok(alunoService.alterar(aluno));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deletePorId(@PathVariable int id){
        alunoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> consultaPorId(@PathVariable int id){
        return ResponseEntity.ok(alunoService.consultarPorId(id));
    }

    @GetMapping("/like/{nome}")
    public ResponseEntity<List<Aluno>> listarPorLike(@PathVariable String nome){
        return ResponseEntity.ok(alunoService.buscarAlunoLike(nome));
    }

    @GetMapping("/mat/{matricula}")
    public ResponseEntity<Aluno> listarPorMatricula(@PathVariable String matricula){
        return ResponseEntity.ok(alunoService.buscarAlunoPorMatricula(matricula));
    }

    @GetMapping("/nome/{nome}/mat/{matricula}")
    public ResponseEntity<Aluno> listarPorNomeMatricula(@PathVariable String matricula, @PathVariable String nome){
        return ResponseEntity.ok(alunoService.buscarAlunoPorMatriculaNome( matricula, nome));
    }

}
