package br.com.itau.transacoes.infra.database.fakedb;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.util.List;


public class TransacaoRepositoryImpl implements TransacaoRepository {

    @Override
    public List<Transacao> getAllByStartTime(Long inicioFiltroEmSegundos) {
        return TransacaoMemoryDB.getInstance().getAllByStartTime(inicioFiltroEmSegundos);
    }

    @Override
    public void deleteAll() {
        TransacaoMemoryDB.getInstance().deleteAll();
    }

    @Override
    public Transacao create(Transacao entity) {
        long randomLong = 1 + (long) (Math.random() * (1000 - 1));
        entity.setId(randomLong);
        return TransacaoMemoryDB.getInstance().create(entity);
    }
}
