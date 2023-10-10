package com.calificationservice.controller;

import com.calificationservice.entity.Calification;
import com.calificationservice.service.CalificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calificaciones")
public class CalificationlController {
    @Autowired
    private CalificationService calificationService;

    @PostMapping
    public ResponseEntity<Calification> saveCalificacion(@RequestBody Calification calification){
        return ResponseEntity.status(HttpStatus.CREATED).body(calificationService.create(calification));
    }

    @GetMapping
    public ResponseEntity<List<Calification>> getAllCalifications(){
        return ResponseEntity.ok(calificationService.getAll());
    }

    @GetMapping("/usuarios/{userId}")
    public ResponseEntity<List<Calification>> getHotelByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(calificationService.getCalificationByUserId(userId));
    }

    @GetMapping("/hoteles/{hotelId}")
    public ResponseEntity<List<Calification>> getHotelByHotelId(@PathVariable Long hotelId){
        return ResponseEntity.ok(calificationService.getCalificationByHotelId(hotelId));
    }
}
