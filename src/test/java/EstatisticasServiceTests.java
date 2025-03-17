import br.com.itau.transacoes.domain.estatistica.EstatisticaService;
import br.com.itau.transacoes.domain.estatistica.EstatisticaServiceImpl;
import br.com.itau.transacoes.infra.database.fakedb.TransacaoMemoryDB;
import br.com.itau.transacoes.infra.database.models.Transacao;
import br.com.itau.transacoes.infra.rest.dto.EstatisticaResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstatisticasServiceTests {

    public EstatisticaService estatisticaService;


    @BeforeEach
    public void init(){
        estatisticaService = new EstatisticaServiceImpl();
    }


    @Test
    public void shouldPassGetEstatisticaWhenInicioFiltroEmSegundosNull(){
       EstatisticaResponseDTO dto = estatisticaService.getEstatistica(null);

        assertEquals(BigDecimal.ZERO, dto.getAvg());
        assertEquals(BigDecimal.ZERO, dto.getMax());
        assertEquals(BigDecimal.ZERO, dto.getMin());
        assertEquals(BigDecimal.ZERO, dto.getSum());
        assertEquals(0, dto.getCount());
    }

    @Test
    public void shouldPassGetEstatisticaWhenInicioFiltroEmSegundosNotNull(){
        Transacao transacao = new Transacao();
        transacao.setValor(BigDecimal.TEN);
        transacao.setDataHora(OffsetDateTime.now());
        TransacaoMemoryDB.getInstance().create(transacao);

        EstatisticaResponseDTO dto = estatisticaService.getEstatistica(6000L);

        assertEquals(new BigDecimal("10.000"), dto.getAvg());
        assertEquals(BigDecimal.TEN, dto.getMax());
        assertEquals(BigDecimal.TEN, dto.getMin());
        assertEquals(BigDecimal.TEN, dto.getSum());
        assertEquals(1, dto.getCount());
    }


}
