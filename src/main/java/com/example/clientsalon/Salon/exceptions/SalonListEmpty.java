package com.example.clientsalon.Salon.exceptions;

import static com.example.clientsalon.System.Constants.SALON_LIST_EMPTY;

public class SalonListEmpty extends RuntimeException{
    public SalonListEmpty() {
        super(SALON_LIST_EMPTY);
    }
}
