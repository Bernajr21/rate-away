package com.msvc.usuario.external.services;

import com.msvc.usuario.entity.Calification;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "CALIFICACION-SERVICE")
public interface CalificationService {

    @PostMapping
    public ResponseEntity<Calification> saveCalification(Calification calification);

    @PostMapping("/calificaciones/{calificationId}")
    public ResponseEntity<Calification> updateCalification(@PathVariable Long calificationId);

    @DeleteMapping("/calificaciones/{calificationId}")
    public void eliminarCalification(@PathVariable Long calificationId);
}
