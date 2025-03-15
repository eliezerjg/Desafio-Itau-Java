package br.com.itau.transacoes.infra.rest.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransacaoRequestDTO {
    public BigDecimal valor;
    public OffsetDateTime dataHora;
}
