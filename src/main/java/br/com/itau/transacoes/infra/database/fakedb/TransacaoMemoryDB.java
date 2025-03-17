package br.com.itau.transacoes.infra.database.fakedb;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class TransacaoMemoryDB {
    private static TransacaoMemoryDB instance = null;
    private List<Transacao> items;

    public static TransacaoMemoryDB getInstance(){
        if(instance == null){
            instance = new TransacaoMemoryDB();
            instance.items = new ArrayList<>();
        }
        return instance;
    }


    // todo: fazer os testes e revisar
    public List<Transacao> getAllByStartTime(Long inicioFiltroEmSegundos) {
        long nowEpoch = Instant.now().getEpochSecond();
        long fromStart = nowEpoch - inicioFiltroEmSegundos;
        List<Transacao> transacoesFiltradas = getInstance().items.stream()
                .filter(n -> n.getDataHora().toEpochSecond() >= fromStart)
                .toList();

        return transacoesFiltradas;
    }


    // todo: fazer os testes e revisar
    public void deleteAll() {
        getInstance().items = new ArrayList<>();
    }

    // todo: fazer os testes e revisar
    public Transacao create(Transacao entity) {
        getInstance().items.add(entity);
        return entity;
    }
}
