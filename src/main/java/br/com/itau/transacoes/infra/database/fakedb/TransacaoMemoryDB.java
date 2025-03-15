package br.com.itau.transacoes.infra.database.fakedb;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
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


    public List<Transacao> getAllByStartTime(Long inicioFiltroEmSegundos) {
        long nowEpoch = Instant.now().getEpochSecond();
        long estimatedStart = nowEpoch - inicioFiltroEmSegundos;

        return getInstance().items.stream()
                .filter(n -> n.getDataHora().toEpochSecond() >= estimatedStart)
                .toList();
    }


    public void deleteAll() {
        getInstance().items = Collections.emptyList();
    }

    public Transacao create(Transacao entity) {
        getInstance().items.add(entity);
        return entity;
    }
}
