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

    @Test
    public void onGetAvg_ShouldNotFail_WhenZeroInstance(){


        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                ),
                2000L
        );

        // act
        BigDecimal avg = utils.getAvg();

        //assert
        assertEquals(BigDecimal.ZERO, avg);
    }

    @Test
    public void onGetAvg_ShouldNotFail_When5ItemsInstance(){

        // arrange
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

        // act
        BigDecimal avg = utils.getAvg();

        //assert
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

        // act
        BigDecimal min = utils.getMin();

        //assert
        assertEquals(BigDecimal.ZERO, min);
    }

    @Test
    public void onGetMin_ShouldNotFail_When5ItemsInstance(){

        // arrange
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

        // act
        BigDecimal min = utils.getMin();

        //assert
        String rounding_with_3_cases_8 = "5.00";
        assertEquals(new BigDecimal(rounding_with_3_cases_8), min);
    }

    @Test
    public void onGetMax_ShouldNotFail_WhenZeroInstance(){


        EstatisticaUtils utils = new EstatisticaUtils(
                List.of(
                ),
                2000L
        );

        // act
        BigDecimal max = utils.getMax();

        //assert
        assertEquals(BigDecimal.ZERO, max);
    }

    @Test
    public void onGetMax_ShouldNotFail_When5ItemsInstance(){

        // arrange
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

        // act
        BigDecimal max = utils.getMax();

        //assert
        String rounding_with_3_cases_8 = "10.00";
        assertEquals(new BigDecimal(rounding_with_3_cases_8), max);
    }


}
