package com.example.clientsalon.Salon.dtos;

import com.example.clientsalon.Salon.model.Salon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateSalonResponse {

    private Salon salon;


    @Builder.Default
    private String message="Salonul a fost creat cu succes";
}
