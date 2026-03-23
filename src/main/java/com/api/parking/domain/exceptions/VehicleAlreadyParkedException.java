package com.api.parking.domain.exceptions;

public class VehicleAlreadyParkedException extends DomainError {
  public VehicleAlreadyParkedException(String message) {
    super(message);
  }
}
