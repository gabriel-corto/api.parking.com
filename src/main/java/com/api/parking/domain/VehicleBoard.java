package com.api.parking.domain;

import com.api.parking.domain.exceptions.InvalidVehicleBoardException;

import lombok.Getter;

@Getter
public class VehicleBoard {
  private String value;
  private final String VEHICLE_REGEX = "^[A-Z]{2}-[0-9]{2}-[0-9]{2}-[A-Z]{2}$";

  public VehicleBoard(String value) {
    this.validateVehicleBoard(value);
    this.value = value;
  }

  private void validateVehicleBoard(String value) {
    if (value == null || !value.matches(VEHICLE_REGEX)) {
      throw new InvalidVehicleBoardException(value);
    }
  }
}
