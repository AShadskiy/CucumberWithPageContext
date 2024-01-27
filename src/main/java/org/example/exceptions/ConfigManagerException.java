package org.example.exceptions;

public class ConfigManagerException extends RuntimeException {

    public ConfigManagerException(String message) {
        super(message);
    }

    public ConfigManagerException(Throwable throwable) {
        super(throwable);
    }

}
