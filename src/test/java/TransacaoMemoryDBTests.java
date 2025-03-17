import br.com.itau.transacoes.infra.database.fakedb.TransacaoMemoryDB;
import br.com.itau.transacoes.infra.database.models.Transacao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class TransacaoMemoryDBTests {
    private TransacaoMemoryDB db = null;

    @BeforeEach
    public void init(){
        db = new TransacaoMemoryDB();
    }

    @Test
    public void shouldPassWhenGetInstance(){
        assertNotNull(TransacaoMemoryDB.getInstance());
    }

    @Test
    public void shouldPassGetAllByStartTimeWhenEmptyDB(){
        db.deleteAll();
        assertEquals(Collections.emptyList(), db.getAllByStartTime(6000L));
    }

    @Test
    public void shouldPassDeleteAllWhenEmptyDB(){
        TransacaoMemoryDB.getInstance().deleteAll();
        assertEquals(Collections.emptyList(), db.getAllByStartTime(6000L));
    }

    @Test
    public void shouldCreateWhenEmptyDB(){
        Transacao transacao = new Transacao();
        transacao.setValor(BigDecimal.TEN);
        transacao.setDataHora(OffsetDateTime.now());
        db.create(transacao);
        assertNotEquals(Collections.emptyList(), db.getAllByStartTime(6000L));
    }

}
