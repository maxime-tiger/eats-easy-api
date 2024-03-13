package com.eatseasy.org.exception;

public class NoResultException extends RuntimeException {

    public NoResultException() {
        super();
    }

    public NoResultException(String message){super(message);}

    public NoResultException(Throwable cause){super(cause);}

    public NoResultException(String message, Throwable cause){super(message, cause);}
}
