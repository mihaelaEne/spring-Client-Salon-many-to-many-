package com.example.clientsalon.Salon.repository;

import com.example.clientsalon.Salon.model.Salon;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalonRepo extends JpaRepository <Salon,Long> {

    @Query("SELECT DISTINCT s.name FROM Salon s")
    List<String> getAllSaloaneByNume();

    @Query("SELECT s FROM Salon s where s.id= ?1")
    @EntityGraph(attributePaths = {"clienti"}, type= EntityGraph.EntityGraphType.LOAD)
    Optional<Salon> findById(Long id);

    @Query("SELECT s FROM Salon s where s.adresa= ?1")
    Optional<Salon>findSalonByAdresa(String adresa);

    @Query("SELECT s FROM Salon s where s.name= ?1")
    Optional<Salon>findSalonByNume(String name);

    @Modifying
    @Query("select s from Salon s where s.name= ?1 and s.adresa= ?2")
    void updateSalon(String name, String adresa);

}
