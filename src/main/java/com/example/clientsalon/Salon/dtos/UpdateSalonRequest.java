package com.example.clientsalon.Salon.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class UpdateSalonRequest {
    private String name="";
    private String adresa="";
}
