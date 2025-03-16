package br.com.itau.transacoes.domain.estatistica;

import br.com.itau.transacoes.infra.database.fakedb.TransacaoRepository;
import br.com.itau.transacoes.infra.database.fakedb.TransacaoRepositoryImpl;
import br.com.itau.transacoes.infra.database.models.Transacao;
import br.com.itau.transacoes.infra.rest.dto.EstatisticaResponseDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstatisticaServiceImpl implements EstatisticaService {

    TransacaoRepository repository = new TransacaoRepositoryImpl();

    @Override
    public EstatisticaResponseDTO getEstatistica(Long parametroFiltroInicioFiltroEmSegundos) {
        /* todo:implementar
        2.2.3. Calcular Estatísticas: GET /estatistica

        Este endpoint deve retornar estatísticas das transações que aconteceram nos últimos 60 segundos (1 minuto). As estatísticas que devem ser calculadas são:

        {
            "count": 10,
            "sum": 1234.56,
            "avg": 123.456,
            "min": 12.34,
            "max": 123.56
        }
        Os campos no JSON acima significam o seguinte:

        Campo	Significado	Obrigatório?
        count	Quantidade de transações nos últimos 60 segundos	Sim
        sum	Soma total do valor transacionado nos últimos 60 segundos	Sim
        avg	Média do valor transacionado nos últimos 60 segundos	Sim
        min	Menor valor transacionado nos últimos 60 segundos	Sim
        max	Maior valor transacionado nos últimos 60 segundos	Sim

        Dica: Há um objeto no Java 8+ chamado DoubleSummaryStatistics que pode lhe ajudar ou servir de inspiração.
        Como resposta, espera-se que este endpoint responda com:

        200 OK com os dados das estatísticas
        Um JSON com os campos count, sum, avg, min e max todos preenchidos com seus respectivos valores
        Atenção! Quando não houverem transações nos últimos 60 segundos considere todos os valores como 0 (zero)
        * */

        Long inicioFiltroEmSegundos = Optional.ofNullable(parametroFiltroInicioFiltroEmSegundos).orElse(60L);

        List<Transacao> transacoes = repository.getAllByStartTime( inicioFiltroEmSegundos );
        if(transacoes.isEmpty()){
            return EstatisticaResponseDTO.filledWithZeroInstance();
        }
        EstatisticaUtils utils = new EstatisticaUtils(transacoes, inicioFiltroEmSegundos);

        EstatisticaResponseDTO estatisticaCalculada = new EstatisticaResponseDTO();
        estatisticaCalculada.setCount( utils.getCount() );
        estatisticaCalculada.setSum( utils.getSum() );
        estatisticaCalculada.setAvg( utils.getAvg() );
        estatisticaCalculada.setMin( utils.getMin() );
        estatisticaCalculada.setMax( utils.getMax() );


        return estatisticaCalculada;
    }
}
