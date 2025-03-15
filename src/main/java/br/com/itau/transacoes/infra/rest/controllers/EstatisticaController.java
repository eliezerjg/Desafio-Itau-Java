package br.com.itau.transacoes.infra.rest.controllers;


import br.com.itau.transacoes.domain.estatistica.EstatisticaService;
import br.com.itau.transacoes.infra.rest.dto.EstatisticaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/estatistica")
public class EstatisticaController {
    private EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService){
        this.estatisticaService = estatisticaService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<EstatisticaResponseDTO> getEstatisticas(@RequestParam(required = false)
                                                                  Long inicioFiltroEmSegundos ){

        EstatisticaResponseDTO estatistica = estatisticaService.getEstatistica(inicioFiltroEmSegundos);
        return  ResponseEntity.ok(estatistica);
    }

}
