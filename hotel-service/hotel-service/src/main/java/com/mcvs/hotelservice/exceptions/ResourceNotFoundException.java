package com.mcvs.hotelservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Recuerso no encontrado en el servidor");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
