package br.com.itau.transacoes.domain.transacao;

import br.com.itau.transacoes.domain.transacao.exceptions.DataFuturaException;
import br.com.itau.transacoes.domain.transacao.exceptions.TransacaoComValorNegativoException;
import br.com.itau.transacoes.infra.database.fakedb.TransacaoRepository;
import br.com.itau.transacoes.infra.database.fakedb.TransacaoRepositoryImpl;
import br.com.itau.transacoes.infra.database.models.Transacao;
import br.com.itau.transacoes.infra.rest.dto.TransacaoRequestDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoServiceImpl  implements TransacaoService{
    TransacaoRepository repository = new TransacaoRepositoryImpl();

    @Override
    public void criarTransacao(TransacaoRequestDTO dto) throws DataFuturaException, TransacaoComValorNegativoException{
        OffsetDateTime agora = OffsetDateTime.now();

        if(dto.getDataHora().isAfter(agora)){
            throw new DataFuturaException("A transacao nao deve ocorrer no futuro");
        }

        if(dto.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new TransacaoComValorNegativoException("Transacao nao deve ter valor negativo");
        }

        Transacao transacao = new Transacao();
        transacao.setDataHora(dto.getDataHora());
        transacao.setValor(dto.getValor());
        repository.create(transacao);
    }

    @Override
    public void deletarTransacoes() {
        repository.deleteAll();
    }
}
