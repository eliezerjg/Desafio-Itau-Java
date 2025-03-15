package br.com.itau.transacoes.sharedKernel.exception;

public class DomainException extends RuntimeException{
    private final Integer httpStatus;

    public DomainException(String message, Integer httpStatus){
        super(message);
        this.httpStatus = httpStatus;
    }
    public DomainException(Throwable throwable, Integer httpStatus){
        super(throwable);
        this.httpStatus = httpStatus;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
