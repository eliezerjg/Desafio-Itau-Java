package br.com.itau.transacoes.sharedKernel.exception;

import java.io.Serializable;

public class ErrorVO implements Serializable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
