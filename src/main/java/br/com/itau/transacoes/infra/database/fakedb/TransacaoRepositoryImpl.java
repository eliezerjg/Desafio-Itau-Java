package br.com.itau.transacoes.infra.database.fakedb;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.lang.reflect.Type;
import java.util.List;


public class TransacaoRepositoryImpl implements FakeDBRepository<Transacao>{

    @Override
    public List getAllByStartTime(Long inicioFiltroEmSegundos) {
        // todo: implementar listagem e filtro
        return List.of();
    }

    @Override
    public void deleteAll(Type t) {
        // delete all from memory
    }

    @Override
    public WrapperEntity create(WrapperEntity entity) {
        long randomLong = 1 + (long) (Math.random() * (1000 - 1));
        entity.setId(randomLong);
        // todo: save on memory
        return entity;
    }
}
