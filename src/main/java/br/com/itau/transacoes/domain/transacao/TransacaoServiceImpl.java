package br.com.itau.transacoes.domain.transacao;

import br.com.itau.transacoes.domain.transacao.exceptions.DataFuturaException;
import br.com.itau.transacoes.domain.transacao.exceptions.DataPassadaException;
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
    public void criarTransacao(TransacaoRequestDTO dto) throws DataFuturaException, DataPassadaException, TransacaoComValorNegativoException{
        /*
        todo:  implementar
        A API só aceitará transações que:

        Tenham os campos valor e dataHora preenchidos
        A transação NÃO DEVE acontecer no futuro
        A transação DEVE ter acontecido a qualquer momento no passado
        A transação NÃO DEVE ter valor negativo
        A transação DEVE ter valor igual ou maior que 0 (zero)
        Como resposta, espera-se que este endpoint responda com:

        201 Created sem nenhum corpo
        A transação foi aceita (ou seja foi validada, está válida e foi registrada)
        422 Unprocessable Entity sem nenhum corpo
        A transação não foi aceita por qualquer motivo (1 ou mais dos critérios de aceite não foram atendidos - por exemplo: uma transação com valor menor que 0)
        400 Bad Request sem nenhum corpo
        A API não compreendeu a requisição do cliente (por exemplo: um JSON inválido)

        */

        OffsetDateTime agora = OffsetDateTime.now();

        // todo: implementar se for no  dia anterior
        if(agora.isBefore(dto.getDataHora())){
            throw new DataPassadaException("A transacao nao deve ocorrer no passado");
        }

        if(agora.isAfter(dto.getDataHora())){
            throw new DataFuturaException("A transacao nao deve ocorrer no futuro");
        }

        if(dto.getValor().compareTo(BigDecimal.ZERO) < 0){
            throw new TransacaoComValorNegativoException("A transacao nao deve ocorrer no passado");
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
