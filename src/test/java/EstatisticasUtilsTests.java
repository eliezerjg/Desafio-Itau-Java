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
        EstatisticaUtils utils = new EstatisticaUtils(List.of(), 2000L);
        int count = utils.getCount();
        assertEquals(0, count);
    }

    @Test
    public void onGetCount_ShouldNotFail_When5ItemsInstance(){
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

        int count = utils.getCount();
        assertEquals(5, count);
    }

    @Test
    public void onGetSum_ShouldNotFail_WhenZeroInstance(){
        EstatisticaUtils utils = new EstatisticaUtils(List.of(), 2000L);
        BigDecimal count = utils.getSum();
        assertEquals(BigDecimal.ZERO, count);
    }

    @Test
    public void onGetSum_ShouldNotFail_When5ItemsInstance(){
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

        BigDecimal count = utils.getSum();

        assertEquals(new BigDecimal("50"), count);
    }

    @Test
    public void onGetAvg_ShouldNotFail_WhenZeroInstance(){


        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                ),
                2000L
        );

        BigDecimal avg = utils.getAvg();
        assertEquals(BigDecimal.ZERO, avg);
    }

    @Test
    public void onGetAvg_ShouldNotFail_When5ItemsInstance(){
        Transacao transacao1 = new Transacao();
        transacao1.setValor(new BigDecimal("10.00"));
        transacao1.setDataHora(OffsetDateTime.now());

        Transacao transacao2 = new Transacao();
        transacao2.setValor(new BigDecimal("5.00"));
        transacao2.setDataHora(OffsetDateTime.now());

        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                        transacao1,
                        transacao1,
                        transacao2,
                        transacao2,
                        transacao1
                ),
                2000L
        );

        BigDecimal avg = utils.getAvg();

        String rounding_with_3_cases_8 = "8.000";
        assertEquals(new BigDecimal(rounding_with_3_cases_8), avg);
    }

    @Test
    public void onGetMin_ShouldNotFail_WhenZeroInstance(){


        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                ),
                2000L
        );

        BigDecimal min = utils.getMin();

        assertEquals(BigDecimal.ZERO, min);
    }

    @Test
    public void onGetMin_ShouldNotFail_When1ItemInstance(){

        Transacao transacao = new Transacao();
        transacao.setDataHora(OffsetDateTime.now());
        transacao.setValor(BigDecimal.TEN);
        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                        transacao
                ),
                2000L
        );

        BigDecimal min = utils.getMin();

        assertEquals(BigDecimal.TEN, min);
    }

    @Test
    public void onGetMin_ShouldNotFail_When5ItemsInstance(){

        Transacao transacao1 = new Transacao();
        transacao1.setValor(new BigDecimal("10.00"));
        transacao1.setDataHora(OffsetDateTime.now());

        Transacao transacao2 = new Transacao();
        transacao2.setValor(new BigDecimal("5.00"));
        transacao2.setDataHora(OffsetDateTime.now());

        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                        transacao1,
                        transacao1,
                        transacao2,
                        transacao2,
                        transacao1
                ),
                2000L
        );

        BigDecimal min = utils.getMin();

        String rounding_with_3_cases_5_00 = "5.00";
        assertEquals(new BigDecimal(rounding_with_3_cases_5_00), min);
    }

    @Test
    public void onGetMax_ShouldNotFail_WhenZeroInstance(){


        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                ),
                2000L
        );

        BigDecimal max = utils.getMax();
        assertEquals(BigDecimal.ZERO, max);
    }

    @Test
    public void onGetMax_ShouldNotFail_When1ItemInstance(){

        Transacao transacao = new Transacao();
        transacao.setValor(BigDecimal.TEN);
        transacao.setDataHora(OffsetDateTime.now());

        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                        transacao
                ),
                2000L
        );

        BigDecimal max = utils.getMax();
        assertEquals(BigDecimal.TEN, max);
    }

    @Test
    public void onGetMax_ShouldNotFail_When5ItemsInstance(){
        Transacao transacao1 = new Transacao();
        transacao1.setValor(new BigDecimal("10.00"));
        transacao1.setDataHora(OffsetDateTime.now());

        Transacao transacao2 = new Transacao();
        transacao2.setValor(new BigDecimal("5.00"));
        transacao2.setDataHora(OffsetDateTime.now());

        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                        transacao1,
                        transacao1,
                        transacao2,
                        transacao2,
                        transacao1
                ),
                2000L
        );

        BigDecimal max = utils.getMax();

        String rounding_with_3_cases_10_00 = "10.00";
        assertEquals(new BigDecimal(rounding_with_3_cases_10_00), max);
    }


}
