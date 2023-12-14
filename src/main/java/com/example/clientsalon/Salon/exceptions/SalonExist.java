package com.example.clientsalon.Salon.exceptions;

import static com.example.clientsalon.System.Constants.SALON_EXIST;

public class SalonExist extends RuntimeException{
    public SalonExist() {
        super(SALON_EXIST);
    }
}
