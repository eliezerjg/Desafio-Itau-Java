package br.com.itau.transacoes.domain.transacao.exceptions;

import br.com.itau.transacoes.sharedKernel.exception.DomainException;
import org.springframework.http.HttpStatus;

public class DataFuturaException extends DomainException {
    private static final Integer httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();

    public DataFuturaException(String message) {
        super(message, httpStatus);
    }

    public DataFuturaException(Throwable throwable) {
        super(throwable, httpStatus);
    }
}
