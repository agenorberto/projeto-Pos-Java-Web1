package dev.fujioka.java.avancado.web.service;

import dev.fujioka.java.avancado.web.dto.MensalidadeDTO;
import dev.fujioka.java.avancado.web.model.Mensalidade;
import dev.fujioka.java.avancado.web.repository.MensalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensalidadeService {

    @Autowired
    private MensalidadeRepository mensalidadeRepository;

    public List<Mensalidade> listarMensalidade(){
        return mensalidadeRepository.findAll();
    }

    private JmsTemplate jmsTemplate;

    public MensalidadeDTO salvar(Mensalidade mensalidade){

        mensalidade = mensalidadeRepository.save(mensalidade);
        jmsTemplate.convertAndSend("matricula_mensalidade_queue", mensalidade);
        return MensalidadeDTO.builder()
                .status(mensalidade.getStatus())
                .valor(mensalidade.getValor())
                .dataVencimento(mensalidade.getDataVencimento())
                .build();
    }

    public Mensalidade alterar(Mensalidade mensalidade){
        return mensalidadeRepository.save(mensalidade);
    }

    public void excluir(int id){
        mensalidadeRepository.deleteById(id);
    }

    public Mensalidade consultarPorId(int id){
        return mensalidadeRepository.findById(id).orElseThrow();
    }
}
