package com.coutodev.a.boa.Exception;

public class UsuarioExcepiton extends RuntimeException {
    public UsuarioExcepiton(String message) {
        super(message);
    }

    public UsuarioExcepiton() {
        super("usuairo não encontrado");
    }
}
