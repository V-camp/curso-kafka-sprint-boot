package io.cursokafka.icompras.pedidos.model.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private String field;
    private String message;

    public ValidationException(String message, String field) {
        super(message);
        this.message = message;
        this.field = field;
    }
}
