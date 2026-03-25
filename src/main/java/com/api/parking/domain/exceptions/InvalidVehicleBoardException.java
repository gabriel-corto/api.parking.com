package com.api.parking.domain.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidVehicleBoardException extends DomainError {
  public InvalidVehicleBoardException() {
    super("Placa do veículo inválida, use o formato AA-00-00-BB", HttpStatus.BAD_REQUEST);
  }
}