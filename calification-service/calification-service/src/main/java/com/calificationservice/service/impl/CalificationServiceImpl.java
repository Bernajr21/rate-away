package com.calificationservice.service.impl;

import com.calificationservice.entity.Calification;
import com.calificationservice.repository.CalificationRepository;
import com.calificationservice.service.CalificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificationServiceImpl implements CalificationService {

    @Autowired
    private CalificationRepository calificationRepository;

    @Override
    public Calification create(Calification calification) {
        return calificationRepository.save(calification);
    }

    @Override
    public List<Calification> getAll() {
        return calificationRepository.findAll();
    }

    @Override
    public List<Calification> getCalificationByUserId(Long userId) {
        return calificationRepository.findByUserId(userId);
    }

    @Override
    public List<Calification> getCalificationByHotelId(Long hotelId) {
        return calificationRepository.findByHotelId(hotelId);
    }
}
