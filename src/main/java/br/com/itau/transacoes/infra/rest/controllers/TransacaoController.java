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
        /*
        todo:  implementar
        A API só aceitará transações que:

        Tenham os campos valor e dataHora preenchidos
        A transação NÃO DEVE acontecer no futuro
        A transação DEVE ter acontecido a qualquer momento no passado
        A transação NÃO DEVE ter valor negativo
        A transação DEVE ter valor igual ou maior que 0 (zero)
        Como resposta, espera-se que este endpoint responda com:

        201 Created sem nenhum corpo
        A transação foi aceita (ou seja foi validada, está válida e foi registrada)
        422 Unprocessable Entity sem nenhum corpo
        A transação não foi aceita por qualquer motivo (1 ou mais dos critérios de aceite não foram atendidos - por exemplo: uma transação com valor menor que 0)
        400 Bad Request sem nenhum corpo
        A API não compreendeu a requisição do cliente (por exemplo: um JSON inválido)

        * */
       return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<Void> deletarTransacoes(){
        /*
        todo:  implementar deletar todas transacoes
        * */
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
