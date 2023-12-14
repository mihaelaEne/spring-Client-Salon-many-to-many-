package com.example.clientsalon.Client.exceptions;

import static com.example.clientsalon.System.Constants.CLIENT_DOESNT_EXIST;

public class ClientDoesntExistException extends RuntimeException{
    public ClientDoesntExistException() {
        super(CLIENT_DOESNT_EXIST);
    }
}
