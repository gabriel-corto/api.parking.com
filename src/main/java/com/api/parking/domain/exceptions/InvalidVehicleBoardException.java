package com.api.parking.domain.exceptions;

public class InvalidVehicleBoardException extends DomainError {
    public InvalidVehicleBoardException(String board) {
        super("Placa " + board + " inválida. Use o formato AB-12-34-CD.");
    }
}