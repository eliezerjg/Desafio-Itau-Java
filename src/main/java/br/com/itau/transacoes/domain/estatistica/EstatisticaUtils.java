package br.com.itau.transacoes.domain.estatistica;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.List;

/*
*
*       Campo	Significado	Obrigatório?
        count	Quantidade de transações nos últimos 60 segundos	Sim
        sum	Soma total do valor transacionado nos últimos 60 segundos	Sim
        avg	Média do valor transacionado nos últimos 60 segundos	Sim
        min	Menor valor transacionado nos últimos 60 segundos	Sim
        max	Maior valor transacionado nos últimos 60 segundos	Sim
*
* */


public class EstatisticaUtils {
    private List<Transacao> transacoes;
    private Long inLastSeconds;

    public EstatisticaUtils(List<Transacao> transacoes, Long inLastSeconds){
        this.transacoes = transacoes;
        this.inLastSeconds = inLastSeconds;
    }

    // todo: escrever os testes e validar
    public int getCount(){
        long nowEpochSecond = Instant.now().getEpochSecond();
        long nowLastSeconds = nowEpochSecond - this.inLastSeconds;
        List<Transacao> transacoesInLastSeconds = this.transacoes.stream().filter(n -> n.getDataHora().toEpochSecond() >= nowLastSeconds).toList();
        return transacoesInLastSeconds.size();
    }

    // todo: escrever os testes e validar
    public BigDecimal getSum(){
        long nowEpochSecond = Instant.now().getEpochSecond();
        long nowLastSeconds = nowEpochSecond - this.inLastSeconds;
        List<Transacao> transacoesInLastSeconds = this.transacoes.stream().filter(n -> n.getDataHora().toEpochSecond() >= nowLastSeconds).toList();
        BigDecimal valorSum = transacoesInLastSeconds.stream()
                .map(Transacao::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);


        return valorSum;
    }

    // todo: escrever os testes e validar
    public BigDecimal getAvg(){
        BigDecimal totalValor = getSum();
        int totalTransacoes = this.transacoes.size();
        return totalValor.divide(BigDecimal.valueOf(totalTransacoes), 3, RoundingMode.CEILING);
    }


    // todo: escrever os testes e validar
    public BigDecimal getMin(){
        BigDecimal minValue = transacoes.getFirst().getValor();

        for(int index = 1; index <= transacoes.size() - 1; index++ ){
            Transacao transacao = transacoes.get(index);

            if(transacao.getValor().compareTo(minValue) < 0){
                minValue = transacao.getValor();
            }
        }

        return minValue;
    }

    // todo: escrever os testes e validar
    public BigDecimal getMax(){
        BigDecimal maxValue = transacoes.getFirst().getValor();

        for(int index = 1; index <= transacoes.size() - 1; index++ ){
            Transacao transacao = transacoes.get(index);

            if(transacao.getValor().compareTo(maxValue) >= 0){
                maxValue = transacao.getValor();
            }
        }

        return maxValue;
    }

}
