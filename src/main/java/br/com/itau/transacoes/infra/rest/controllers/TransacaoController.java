package br.com.itau.transacoes.infra.rest.controllers;

import br.com.itau.transacoes.domain.transacao.TransacaoService;
import br.com.itau.transacoes.infra.rest.dto.TransacaoRequestDTO;
import br.com.itau.transacoes.sharedKernel.exception.ErrorVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/transacao")
@Tag(name = "Transacao", description = "operacoes relacionadas a transacao")
public class TransacaoController {
    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping(path = "/")
    @Operation(summary = "cria uma transacao")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Transacao criada"),

            @ApiResponse(responseCode = "422", description = "Transacao Nao deve ocorrer no futuro ou Transacao com Valor Negativo",
                    content = @Content(schema = @Schema(implementation = ErrorVO.class)))

    })
    public ResponseEntity<Void> criarTransacao(@RequestBody TransacaoRequestDTO dto){
        transacaoService.criarTransacao(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/")
    @Operation(summary = "deleta todas transacoes")
    public ResponseEntity<Void> deletarTransacoes(){
        transacaoService.deletarTransacoes();
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
