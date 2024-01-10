package com.example.clientsalon.Client.model;

import com.example.clientsalon.Salon.model.Salon;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Client")
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Client {
    @Id
    @SequenceGenerator(name = "client_sequence", sequenceName = "client_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_sequence")
    private Long id;


    @Column(name = "nume")
    @NotBlank(message = "Numele este necessar")
    private String nume;


    @Column(name = "descriereProgramareSalon")
    @NotBlank(message = "Descrierea este necesara")
    private String descriereProgramareSalon;

    @Column(name = "numeEstetician")
    @NotBlank(message = "Nume estetician este necesara")
    private String numeEstetician;

    @JsonManagedReference
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "salonTime",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "salon_id")
    )

    private List<Salon> saloane=new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", descriereProgramareSalon='" + descriereProgramareSalon + '\'' +
                ", numeEstetician='" + numeEstetician + '\'' +
                ", saloane=" + saloane +
                '}';
    }
}
