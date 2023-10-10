package com.calificationservice.service;

import com.calificationservice.entity.Calification;
import org.springframework.stereotype.Service;


import java.util.List;


public interface CalificationService {

    Calification create(Calification calification);

    List<Calification> getAll();

    List<Calification> getCalificationByUserId(Long userId);

    List<Calification> getCalificationByHotelId(Long hotelId);

}
