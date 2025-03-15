package br.com.itau.transacoes.infra.database.fakedb;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.lang.reflect.Type;
import java.util.List;

public interface TransacaoRepository {
    public List<Transacao> getAllByStartTime(Long inicioFiltroEmSegundos);
    public void deleteAll(Type t);
    public Transacao create(Transacao entity);
}
