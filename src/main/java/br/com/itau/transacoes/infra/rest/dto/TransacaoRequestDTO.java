package br.com.itau.transacoes.infra.rest.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransacaoRequestDTO {
    private BigDecimal valor;
    private OffsetDateTime dataHora;

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
