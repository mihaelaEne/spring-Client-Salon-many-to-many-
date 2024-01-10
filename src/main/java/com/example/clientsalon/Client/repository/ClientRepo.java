package com.example.clientsalon.Client.repository;

import com.example.clientsalon.Client.model.Client;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ClientRepo extends JpaRepository<Client, Long> {
    @Query("SELECT DISTINCT c.nume from Client c")
    List<String> getAllClientiName();

    @Query("SELECT c from Client c where c.nume= ?1")
    @EntityGraph(attributePaths = {"saloane"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Client> findClientByNume(String nume);

    @Query("SELECT c from Client c where c.id= ?1")
    @EntityGraph(attributePaths = {"saloane"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Client> findById(Long id);

    @Query("select c from Client c where c.nume= ?1 and c.numeEstetician= ?2 " )
    Optional<Client> findByNumeAndNumeEstetician (String name, String numeEstetician);

    @Modifying
    @Query("select c from Client c where c.nume= ?1 and c.numeEstetician= ?2 " )
    void updateClinet(String name, String numeEstetician);

}
