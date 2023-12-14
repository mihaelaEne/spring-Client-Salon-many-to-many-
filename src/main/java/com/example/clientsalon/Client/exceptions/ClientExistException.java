package com.example.clientsalon.Client.exceptions;

import static com.example.clientsalon.System.Constants.CLIENT_EXIST;

public class ClientExistException extends RuntimeException{
    public ClientExistException() {
        super(CLIENT_EXIST);
    }
}
