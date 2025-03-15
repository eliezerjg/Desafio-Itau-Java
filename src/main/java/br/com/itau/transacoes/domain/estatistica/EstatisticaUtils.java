package br.com.itau.transacoes.domain.estatistica;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.math.BigDecimal;
import java.util.List;

public class EstatisticaUtils {
    private List<Transacao> transacoes;

    public EstatisticaUtils(List<Transacao> transacoes){
        this.transacoes = transacoes;
    }

    public int getCount(){
        //todo : implementar logica do contador
        return 0;
    }

    public BigDecimal getSum(){
        //todo : implementar cologicantagem da soma total de valores
        return BigDecimal.ZERO;
    }

    public BigDecimal getAvg(){
        //todo : implementar logica do valor medio de transacao
        return BigDecimal.ZERO;
    }

    public BigDecimal getMin(){
        //todo : implementar logica do valor minimo de transacao
        return BigDecimal.ZERO;
    }

    public BigDecimal getMax(){
        //todo : implementar logica do valor maximo de transacao
        return BigDecimal.ZERO;
    }

}
