package com.msvc.usuario.service.impl;

import com.msvc.usuario.entity.Calification;
import com.msvc.usuario.entity.Hotel;
import com.msvc.usuario.entity.User;
import com.msvc.usuario.exceptions.ResourceNotFoundException;
import com.msvc.usuario.external.services.HotelService;
import com.msvc.usuario.repository.UserRepository;
import com.msvc.usuario.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado con el ID " + userId));

        //Obtenemos el el listado de calificaciones en base al usuario del Id
        Calification[] calificationsUser = restTemplate.getForObject("http://CALIFICACION-SERVICE/calificaciones/usuarios/" + user.getUserId(),Calification[].class);

        List<Calification> calificationList = Arrays.stream(calificationsUser).collect(Collectors.toList());

        List<Calification> listaCalificaciones = calificationList.stream().map(calification -> {
            System.out.println(calification.getHotelId());
            Hotel hotel = hotelService.getHotel(calification.getHotelId());
            calification.setHotel(hotel);
            return calification;
        }).collect(Collectors.toList());

        user.setCalifications(listaCalificaciones);

        return user;
    }
}
