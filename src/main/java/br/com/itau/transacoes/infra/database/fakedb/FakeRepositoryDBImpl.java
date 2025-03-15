package br.com.itau.transacoes.infra.database.fakedb;

import java.lang.reflect.Type;
import java.util.List;


public class FakeRepositoryDBImpl implements FakeDBRepository{
    @Override
    public List getAll() {
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
