package com.mcvs.hotelservice.service;

import com.mcvs.hotelservice.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel getHotel(Long id);
}
