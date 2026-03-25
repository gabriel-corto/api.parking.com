package com.api.parking.domain.exceptions;

import org.springframework.http.HttpStatus;

public class VehicleAlreadyParkedException extends DomainError {
  public VehicleAlreadyParkedException() {
    super("Veículo já está estacionado.", HttpStatus.CONFLICT);
  }
}
