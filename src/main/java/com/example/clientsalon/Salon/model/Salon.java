package com.example.clientsalon.Salon.model;

import com.example.clientsalon.Client.model.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Salon")
@Table(name = "salon")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Salon {
    @Id
    @SequenceGenerator(name = "salon_sequence", sequenceName = "salon_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salon_sequence")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "Name is necessary")
    private String name;

    @Column(name = "adresa")
    @NotBlank(message = "Adresa este necesara")
    private String adresa;

    @JsonBackReference
    @ManyToMany(mappedBy = "saloane", fetch = FetchType.LAZY)
    private List<Client> clienti = new ArrayList<>();

    @Override
    public String toString() {
        return "Salon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adresa='" + adresa + '\'' +
                ", clienti=" + clienti +
                '}';
    }
}
