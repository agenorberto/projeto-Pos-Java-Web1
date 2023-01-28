package dev.fujioka.java.avancado.web.dto;

import lombok.Builder;

import java.time.Instant;

@Builder
public class MensalidadeDTO {

    private String status;
    private Double valor;
    private Instant dataVencimento;
}
