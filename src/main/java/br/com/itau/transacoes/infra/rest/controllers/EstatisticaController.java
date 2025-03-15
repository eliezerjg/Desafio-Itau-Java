package br.com.itau.transacoes.infra.rest.controllers;


import br.com.itau.transacoes.domain.estatistica.EstatisticaService;
import br.com.itau.transacoes.infra.rest.dto.EstatisticaResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/estatistica")
public class EstatisticaController {
    private EstatisticaService estatisticaService;

    public EstatisticaController(EstatisticaService estatisticaService){
        this.estatisticaService = estatisticaService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<EstatisticaResponseDTO> getEstatisticas(HttpServletRequest request){
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
        Long inicioFiltroEmSegundos = 60L;

        Optional<Object> optionalTempoInicialEmSegundos = Optional.ofNullable(request.getParameter("inicioFiltroEmSegundos"));
        if(optionalTempoInicialEmSegundos.isPresent()){
            inicioFiltroEmSegundos = Long.parseLong((String) optionalTempoInicialEmSegundos.get());
        }
        EstatisticaResponseDTO estatistica = estatisticaService.getEstatistica(inicioFiltroEmSegundos);
        return  ResponseEntity.ok(estatistica);
    }

}
