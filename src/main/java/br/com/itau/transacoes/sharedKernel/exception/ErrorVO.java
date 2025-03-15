package br.com.itau.transacoes.sharedKernel.exception;

import java.io.Serializable;

public class ErrorVO implements Serializable {
    private Integer httpStatus;
    private String message;

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
