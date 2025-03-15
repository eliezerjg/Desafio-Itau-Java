package br.com.itau.transacoes.domain.estatistica;

import br.com.itau.transacoes.infra.rest.dto.EstatisticaResponseDTO;

import java.util.Optional;


public interface EstatisticaService {
    EstatisticaResponseDTO getEstatistica(Optional<Long> inicioFiltroEmSegundos);
}
