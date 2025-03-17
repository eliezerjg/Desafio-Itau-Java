package br.com.itau.transacoes.domain.estatistica;

import br.com.itau.transacoes.infra.rest.dto.EstatisticaResponseDTO;



public interface EstatisticaService {
    EstatisticaResponseDTO getEstatistica(Long inicioFiltroEmSegundos);
}
