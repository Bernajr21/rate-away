package com.calificationservice.repository;

import com.calificationservice.entity.Calification;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CalificationRepository extends MongoRepository<Calification,Long> {

    List<Calification> findByUserId(Long userId);
    List<Calification> findByHotelId(Long hotelId);
}
