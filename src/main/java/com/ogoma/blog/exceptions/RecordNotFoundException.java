package com.ogoma.blog.exceptions;

public class RecordNotFoundException extends RuntimeException{

  public   RecordNotFoundException(String message){}

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecordNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RecordNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
