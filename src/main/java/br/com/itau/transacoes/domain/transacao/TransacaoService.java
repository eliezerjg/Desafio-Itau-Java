package br.com.itau.transacoes.domain.transacao;

import br.com.itau.transacoes.infra.rest.dto.TransacaoRequestDTO;

public interface TransacaoService {
    public void criarTransacao(TransacaoRequestDTO dto);
    public void deletarTransacoes();
}
