package io.github.hboufaied.kata.exception;

public class FileFormatInvalidException extends RuntimeException{
    public FileFormatInvalidException(String message) {
        super(message);
    }

    public FileFormatInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

}
