import br.com.itau.transacoes.domain.transacao.TransacaoService;
import br.com.itau.transacoes.infra.database.fakedb.TransacaoRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransacaoServiceTests {

    // inject mocks
    @InjectMocks
    public TransacaoService service;

    @Mock
    public TransacaoRepository repository;




}
