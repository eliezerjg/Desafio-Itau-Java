package br.com.itau.transacoes.domain.estatistica;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.util.List;

public class EstatisticaUtils {
    private List<Transacao> transacoes;

    public EstatisticaUtils(List<Transacao> transacoes){
        this.transacoes = transacoes;
    }

    public int count(){
        //todo : implementar logica do contador
        return 0;
    }

    public int sum(){
        //todo : implementar cologicantagem da soma total de valores
        return 0;
    }

    public int avg(){
        //todo : implementar logica do valor medio de transacao
        return 0;
    }

    public int min(){
        //todo : implementar logica do valor minimo de transacao
        return 0;
    }

    public int max(){
        //todo : implementar logica do valor maximo de transacao
        return 0;
    }

}
