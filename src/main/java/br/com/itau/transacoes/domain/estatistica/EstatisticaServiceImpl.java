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
