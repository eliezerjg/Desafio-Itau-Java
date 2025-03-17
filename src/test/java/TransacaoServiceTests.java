import br.com.itau.transacoes.domain.transacao.TransacaoService;
import br.com.itau.transacoes.domain.transacao.TransacaoServiceImpl;
import br.com.itau.transacoes.domain.transacao.exceptions.DataFuturaException;
import br.com.itau.transacoes.domain.transacao.exceptions.TransacaoComValorNegativoException;
import br.com.itau.transacoes.infra.rest.dto.TransacaoRequestDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransacaoServiceTests {

    public TransacaoService service;

    @BeforeEach
    public void init(){
        service = new TransacaoServiceImpl();
    }

    @Test
    public void shouldCreateWhenNormalCall(){
        OffsetDateTime agora = OffsetDateTime.now();

        TransacaoRequestDTO dto = new TransacaoRequestDTO();
        dto.setDataHora(agora);
        dto.setValor(new BigDecimal("29.00"));


        assertDoesNotThrow(() -> service.criarTransacao(dto));
    }

    @Test
    public void shouldThrowDataFuturaExceptionWhenDataFutura(){
        OffsetDateTime future = OffsetDateTime.of(9000,12,15,4,5,0,9,ZoneOffset.UTC);

        TransacaoRequestDTO dto = new TransacaoRequestDTO();
        dto.setDataHora(future);
        dto.setValor(BigDecimal.TEN);


        assertThrows(DataFuturaException.class, () -> service.criarTransacao(dto));
    }

    @Test
    public void shouldThrowTransacaoComValorNegativoExceptionExceptionWhenValorNegativo(){
        OffsetDateTime agora = OffsetDateTime.now();

        TransacaoRequestDTO dto = new TransacaoRequestDTO();
        dto.setDataHora(agora);
        dto.setValor(new BigDecimal("-29.00"));


        assertThrows(TransacaoComValorNegativoException.class, () -> service.criarTransacao(dto));
    }


}
