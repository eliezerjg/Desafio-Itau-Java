package br.com.itau.transacoes.infra.database.fakedb;

import java.util.List;

public interface FakeDBRepository<T> {
    public List<T> getAll();
    public void deleteAll(T entity);
    public T create();
}
