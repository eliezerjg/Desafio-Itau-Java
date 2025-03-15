package br.com.itau.transacoes.infra.database.models;

import br.com.itau.transacoes.infra.database.fakedb.WrapperEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transacao  extends WrapperEntity implements Serializable {
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
