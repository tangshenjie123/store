package com.tangshenjie.store.service.ex;

public class UsernameAlreadyExsitException extends RuntimeException {
    public UsernameAlreadyExsitException() {

    }

    public UsernameAlreadyExsitException(String message) {
        super(message);
    }
}
