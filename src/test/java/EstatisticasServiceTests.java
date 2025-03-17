import br.com.itau.transacoes.domain.estatistica.EstatisticaService;
import br.com.itau.transacoes.infra.database.fakedb.TransacaoRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EstatisticasServiceTests {

    @InjectMocks
    public EstatisticaService estatisticaService;

    @Mock
    public TransacaoRepository repository;



}
