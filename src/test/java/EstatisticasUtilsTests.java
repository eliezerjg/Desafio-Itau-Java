import br.com.itau.transacoes.domain.estatistica.EstatisticaUtils;
import br.com.itau.transacoes.infra.database.models.Transacao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EstatisticasUtilsTests {

    @Test
    public void onGetCount_ShouldNotFail_WhenZeroInstance(){
        // arrange
        EstatisticaUtils utils = new EstatisticaUtils(List.of(), 2000L);

        // act
        int count = utils.getCount();

        //assert
        assertEquals(0, count);
    }

    @Test
    public void onGetCount_ShouldNotFail_When5ItemsInstance(){
        // arrange
        Transacao transacao = new Transacao();
        transacao.setValor(BigDecimal.TEN);
        transacao.setDataHora(OffsetDateTime.now());

        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                        transacao,
                        transacao,
                        transacao,
                        transacao,
                        transacao
        ), 2000L);

        // act
        int count = utils.getCount();

        //assert
        assertEquals(5, count);
    }

    @Test
    public void onGetSum_ShouldNotFail_WhenZeroInstance(){
        // arrange
        EstatisticaUtils utils = new EstatisticaUtils(List.of(), 2000L);

        // act
        BigDecimal count = utils.getSum();

        //assert
        assertEquals(BigDecimal.ZERO, count);
    }

    @Test
    public void onGetSum_ShouldNotFail_When5ItemsInstance(){
        // arrange
        Transacao transacao = new Transacao();
        transacao.setValor(BigDecimal.TEN);
        transacao.setDataHora(OffsetDateTime.now());

        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                        transacao,
                        transacao,
                        transacao,
                        transacao,
                        transacao
                ),
                2000L
        );

        // act
        BigDecimal count = utils.getSum();

        //assert
        assertEquals(new BigDecimal("50"), count);
    }

}
