package dev.fujioka.java.avancado.web.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@Entity
@Data
public class Mensalidade {

    @Id
    @GeneratedValue
    private Integer id;
    private String mes;
    private String status;
    private Double valor;
    private Instant dataPagamento;
    private Instant dataVencimento;
}
