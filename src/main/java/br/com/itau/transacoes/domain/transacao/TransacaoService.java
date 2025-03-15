package br.com.itau.transacoes.domain.transacao;

import br.com.itau.transacoes.domain.transacao.exceptions.DataFuturaException;
import br.com.itau.transacoes.domain.transacao.exceptions.DataPassadaException;
import br.com.itau.transacoes.domain.transacao.exceptions.TransacaoComValorNegativoException;
import br.com.itau.transacoes.infra.rest.dto.TransacaoRequestDTO;

public interface TransacaoService {
    public void criarTransacao(TransacaoRequestDTO dto) throws DataFuturaException, DataPassadaException, TransacaoComValorNegativoException;
    public void deletarTransacoes();
}
