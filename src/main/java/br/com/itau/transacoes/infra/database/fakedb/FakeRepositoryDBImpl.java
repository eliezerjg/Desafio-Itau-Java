package br.com.itau.transacoes.infra.database.fakedb;

import java.util.List;

public class FakeRepositoryDBImpl implements FakeDBRepository{
    @Override
    public List getAll() {
        return List.of();
    }

    @Override
    public void deleteAll(Object entity) {

    }

    @Override
    public Object create() {
        return null;
    }
}
