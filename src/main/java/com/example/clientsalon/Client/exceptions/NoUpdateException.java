package com.example.clientsalon.Client.exceptions;

import static com.example.clientsalon.System.Constants.NO_UPDATE;

public class NoUpdateException extends RuntimeException{
    public NoUpdateException() {
        super(NO_UPDATE);
    }
}
