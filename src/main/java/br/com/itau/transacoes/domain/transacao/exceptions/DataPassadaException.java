package br.com.itau.transacoes.domain.transacao.exceptions;

import br.com.itau.transacoes.sharedKernel.exception.DomainException;
import org.springframework.http.HttpStatus;

public class DataPassadaException extends DomainException {
    private static final Integer httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();

    public DataPassadaException(String message) {
        super(message, httpStatus);
    }

    public DataPassadaException(Throwable throwable) {
        super(throwable, httpStatus);
    }
}
