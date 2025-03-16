package br.com.itau.transacoes.infra.database.fakedb;

import br.com.itau.transacoes.infra.database.models.Transacao;

import java.util.List;

public interface TransacaoRepository {
    List<Transacao> getAllByStartTime(Long inicioFiltroEmSegundos);
    void deleteAll();
    Transacao create(Transacao entity);
}
