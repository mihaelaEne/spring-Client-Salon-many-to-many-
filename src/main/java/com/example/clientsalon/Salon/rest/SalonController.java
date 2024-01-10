package com.example.clientsalon.Salon.rest;

import com.example.clientsalon.Salon.dtos.CreateSalonRequest;
import com.example.clientsalon.Salon.dtos.CreateSalonResponse;
import com.example.clientsalon.Salon.dtos.UpdateSalonRequest;
import com.example.clientsalon.Salon.model.Salon;
import com.example.clientsalon.Salon.service.SalonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salon")
@AllArgsConstructor
@Slf4j
public class SalonController {

    private SalonService salonService;

    @GetMapping("/allSaloane")
    public ResponseEntity<List<Salon>> getAllSaloane() {
        List<Salon> saloane=salonService.getAllSaloane();
        return new ResponseEntity<>(saloane, HttpStatus.OK);
    }

    @PostMapping("/createSalon")
    public ResponseEntity<CreateSalonResponse>addSalon(@RequestBody CreateSalonRequest createSalonRequest){
        CreateSalonResponse createSalonResponse=salonService.addSalon(createSalonRequest);
        return new ResponseEntity<>(createSalonResponse,HttpStatus.CREATED);
    }


    @PutMapping("/updateSalon")
    public ResponseEntity<Void> updateSalon(@RequestBody UpdateSalonRequest updateSalonRequest){
        salonService.updateSalon(updateSalonRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        salonService.deleteSalon(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
