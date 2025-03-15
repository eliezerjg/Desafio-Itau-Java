package br.com.itau.transacoes.infra.rest.exception;

import br.com.itau.transacoes.sharedKernel.exception.DomainException;
import br.com.itau.transacoes.sharedKernel.exception.ErrorVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    private final Logger log;

    public RestExceptionHandler(){
         this.log = LoggerFactory.getLogger(RestExceptionHandler.class);
    }

    @ExceptionHandler(value = { DomainException.class})
    protected ResponseEntity<ErrorVO> handleDomainError(DomainException e) {
        ErrorVO error = new ErrorVO();
        error.setMessage(e.getMessage());
        log.error("Erro:", e);
        return new ResponseEntity<>(error,new HttpHeaders(), e.getHttpStatus());
    }

    @ExceptionHandler(value = { Exception.class})
    protected ResponseEntity<ErrorVO> handleGenericError(Exception e) {
        ErrorVO error = new ErrorVO();
        error.setMessage( HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase() );
        log.error("Erro:", e);
        return new ResponseEntity<>(error,new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
