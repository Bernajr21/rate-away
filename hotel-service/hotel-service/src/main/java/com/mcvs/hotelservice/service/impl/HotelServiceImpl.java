package com.mcvs.hotelservice.service.impl;

import com.mcvs.hotelservice.entity.Hotel;
import com.mcvs.hotelservice.exceptions.ResourceNotFoundException;
import com.mcvs.hotelservice.repository.HotelRepository;
import com.mcvs.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel no encontrado con el id " + id));
    }
}
