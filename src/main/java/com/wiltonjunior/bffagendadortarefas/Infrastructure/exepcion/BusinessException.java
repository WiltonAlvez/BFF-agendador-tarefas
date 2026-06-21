package com.wiltonjunior.bffagendadortarefas.Infrastructure.exepcion;

public class BusinessException extends RuntimeException {


    public BusinessException(String mensagem) {
        super(mensagem);
    }

    public BusinessException(String mensagem, Throwable throwable) {
        super(mensagem, throwable);
    }
}

