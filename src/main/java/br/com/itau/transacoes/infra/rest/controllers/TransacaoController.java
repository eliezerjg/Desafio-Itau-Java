package br.com.itau.transacoes.infra.rest.controllers;

import br.com.itau.transacoes.domain.transacao.TransacaoService;
import br.com.itau.transacoes.infra.rest.dto.TransacaoRequestDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/transacao")
public class TransacaoController {
    private TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService){
        this.transacaoService = transacaoService;
    }

    @PostMapping(path = "/")
    public ResponseEntity<Void> criarTransacao(TransacaoRequestDTO dto){
        transacaoService.criarTransacao(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<Void> deletarTransacoes(){
        transacaoService.deletarTransacoes();
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
