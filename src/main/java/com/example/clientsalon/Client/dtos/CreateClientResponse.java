package com.example.clientsalon.Client.dtos;

import com.example.clientsalon.Client.model.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateClientResponse {
    private Client client;

    @Builder.Default
    private String message="Clientul a fost creat cu succes";
}
