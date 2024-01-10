package com.example.clientsalon.Client.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePrgrSalonClient {

    private int salonId;
    private int clientId;
}
