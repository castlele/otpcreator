package com.castlele.otpcreator.exception;

public class OtpCodeNotActiveException extends RuntimeException{
    public OtpCodeNotActiveException() {
        super("OTP code not active.");
    }
}
