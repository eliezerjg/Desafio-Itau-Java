package br.com.itau.transacoes.infra.database.fakedb;

import br.com.itau.transacoes.infra.database.models.Transacao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class TransacaoRepositoryImpl implements TransacaoRepository {

    private  Logger log;

    public TransacaoRepositoryImpl(){
        this.log = LoggerFactory.getLogger(TransacaoRepositoryImpl.class);
    }

    @Override
    public List<Transacao> getAllByStartTime(Long inicioFiltroEmSegundos) {
        List<Transacao> itensFiltrados = TransacaoMemoryDB.getInstance().getAllByStartTime(inicioFiltroEmSegundos);
        log.info("Foram encontrados %d itens filtrados, apartir de %d segundos atras"
                .formatted(itensFiltrados.size(), inicioFiltroEmSegundos)
        );
        return itensFiltrados;
    }

    @Override
    public void deleteAll() {
        TransacaoMemoryDB.getInstance().deleteAll();
        log.warn("!!! As transacoes foram Deletadas !!!");
    }

    @Override
    public Transacao create(Transacao entity) {
        long randomLong = 1 + (long) (Math.random() * (1000 - 1));
        entity.setId(randomLong);
        Transacao createdEntityInstance = TransacaoMemoryDB.getInstance().create(entity);
        log.info("Nova Transacao criada id [%d], valor [%f], dataHora [%s]"
                .formatted(
                        createdEntityInstance.getId(),
                        createdEntityInstance.getValor(),
                        createdEntityInstance.getDataHora().toString()
                ));
        return createdEntityInstance;
    }
}
