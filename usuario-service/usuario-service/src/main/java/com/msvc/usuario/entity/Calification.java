package com.msvc.usuario.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calification {

    private Long id;

    private Long userId;

    private Long hotelId;

    private int calification;

    private String review;

    private Hotel hotel;
}
