package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.model.Mensalidade;
import dev.fujioka.java.avancado.web.model.Professor;
import dev.fujioka.java.avancado.web.service.MensalidadeService;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensalidade")
public class MensalidadeResource {

    @Autowired
    private MensalidadeService mensalidadeService;

    //Listar Mensalidades
    @GetMapping
    public ResponseEntity<List<Mensalidade>> getMensalidade(){
        return ResponseEntity.ok(mensalidadeService.listarMensalidade());
    }

    //Salvar Mensalidades
    @PostMapping
    public ResponseEntity<Mensalidade> salvar(@RequestBody Mensalidade mensalidade){
        return ResponseEntity.ok(mensalidadeService.salvar(mensalidade));
    }

    //Alterar Mensalidade
    @PutMapping
    public ResponseEntity<Mensalidade> alterar(@RequestBody Mensalidade mensalidade){
        return ResponseEntity.ok(mensalidadeService.alterar(mensalidade));
    }

    //Deletar Mensalidade
    @DeleteMapping("/{id}")
    public ResponseEntity<Mensalidade> deletar(@PathVariable int id){
        mensalidadeService.excluir(id);
        return ResponseEntity.ok().build();
    }

    //Consultar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mensalidade> consultarPorId(@PathVariable int id){
        return ResponseEntity.ok(mensalidadeService.consultarPorId(id));
    }
}
