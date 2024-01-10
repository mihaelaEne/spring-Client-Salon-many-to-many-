package com.example.clientsalon.Salon.exceptions;

import static com.example.clientsalon.System.Constants.SALON_DOESNT_EXIST;

public class SalonDoesntExist extends RuntimeException{

    public SalonDoesntExist() {
        super(SALON_DOESNT_EXIST);
    }
}
