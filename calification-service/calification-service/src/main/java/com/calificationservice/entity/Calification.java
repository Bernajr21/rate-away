package com.calificationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("calificacion")
public class Calification {

    @Id
    private Long id;

    private Long userId;

    private Long hotelId;

    private int calification;

    private String review;
}
