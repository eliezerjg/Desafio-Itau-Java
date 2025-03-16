package br.com.itau.transacoes.infra.rest.controllers;


import br.com.itau.transacoes.domain.estatistica.EstatisticaService;
import br.com.itau.transacoes.infra.rest.dto.EstatisticaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/estatistica")
@Tag(name = "Estatistica", description = "operacoes relacionadas as estatisticas de transacao")
public class EstatisticaController {
    private EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService){
        this.estatisticaService = estatisticaService;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "tras as estatisticas apartir do filtro inicioFiltroEmSegundos ou padrao 60 segundos")
    public ResponseEntity<EstatisticaResponseDTO> getEstatisticas(@RequestParam(required = false)
                                                                  Long inicioFiltroEmSegundos ){
        EstatisticaResponseDTO estatistica = estatisticaService.getEstatistica(inicioFiltroEmSegundos);
        return  ResponseEntity.ok(estatistica);
    }

}
