package com.iiitb.imageEffectApplication.exception;

public class IllegalParameterException extends Exception {
    // This class is responsible for handling exceptions related to illegal
    // parameters

    public IllegalParameterException() {
        super();
    }

    public IllegalParameterException(String message) {
        super(message);
    }

    public IllegalParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalParameterException(Throwable cause) {
        super(cause);
    }
}
