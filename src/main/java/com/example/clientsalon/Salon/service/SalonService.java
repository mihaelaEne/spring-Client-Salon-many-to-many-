package com.example.clientsalon.Salon.service;

import com.example.clientsalon.Salon.dtos.CreateSalonRequest;
import com.example.clientsalon.Salon.dtos.CreateSalonResponse;
import com.example.clientsalon.Salon.dtos.UpdateSalonRequest;
import com.example.clientsalon.Salon.exceptions.SalonDoesntExist;
import com.example.clientsalon.Salon.exceptions.SalonExist;
import com.example.clientsalon.Salon.model.Salon;
import com.example.clientsalon.Salon.repository.SalonRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {

    private SalonRepo salonRepo;

    public SalonService(SalonRepo salonRepo) {
        this.salonRepo = salonRepo;
    }


    public List<Salon> getAllSaloane(){
        List<Salon>all=salonRepo.findAll();
        if(all.size()==0){
            throw new SalonExist();
        }
        return all;
    }

    @Transactional
    public CreateSalonResponse addSalon(CreateSalonRequest createSalonRequest){
        Optional<Salon> salonByNume=salonRepo.findSalonByNume(createSalonRequest.getName());

        if(salonByNume.isPresent()){
            throw new SalonExist();
        }

        Salon salon=Salon.builder()
                .name(createSalonRequest.getName())
                .adresa(createSalonRequest.getAdresa())
                .build();

        Salon salon1=salonRepo.saveAndFlush(salon);

        return CreateSalonResponse.builder().salon(salon1).build();
    }


    @Transactional
    public void deleteSalon(long id){
        Optional<Salon>salon=salonRepo.findById(id);

        if(salon.isPresent()){
            salonRepo.delete(salon.get());
        }
        else{
            throw new SalonDoesntExist();
        }
    }

    @Transactional
    public void updateSalon(UpdateSalonRequest updateSalonRequest) {
        Optional<Salon> salonOptional = salonRepo.findSalonByAdresa(updateSalonRequest.getAdresa());

        if (salonOptional.isPresent()) {
            Salon salon = salonOptional.get();

            if (!updateSalonRequest.getAdresa().equals("")) {
                salon.setAdresa(updateSalonRequest.getAdresa());
            }

            salonRepo.saveAndFlush(salon);
        }
    }




}
