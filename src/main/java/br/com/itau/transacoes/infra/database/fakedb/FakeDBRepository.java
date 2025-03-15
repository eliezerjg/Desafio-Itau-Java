package br.com.itau.transacoes.infra.database.fakedb;

import java.lang.reflect.Type;
import java.util.List;

public interface FakeDBRepository<T> {
    public List<T> getAll();
    public void deleteAll(Type t);
    public <T extends WrapperEntity> T create(T entity);
}
