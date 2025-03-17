import br.com.itau.transacoes.infra.database.fakedb.TransacaoRepository;
import br.com.itau.transacoes.infra.database.fakedb.TransacaoRepositoryImpl;
import br.com.itau.transacoes.infra.database.models.Transacao;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class TransacaoRepositoryTests {
    private final TransacaoRepository repository = new TransacaoRepositoryImpl();

    @Test
    public void shouldPassGetAllByStartTimeWhenNormalCall(){
        assertEquals(Collections.emptyList(),  repository.getAllByStartTime(6000L));
    }

    @Test
    public void shouldDeleteAllByStartTimeWhenNormalCall(){
        repository.deleteAll();
        assertEquals(Collections.emptyList(),  repository.getAllByStartTime(6000L));
    }

    @Test
    public void shouldCreateWhenNormalCall(){
        Transacao transacao = new Transacao();
        transacao.setDataHora(OffsetDateTime.now());
        transacao.setValor(BigDecimal.TEN);
        Transacao transacaoCriada = repository.create(transacao);

        assertNotNull(transacaoCriada.getId());
    }

}
