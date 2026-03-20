package com.api.parking.domain;

import lombok.Getter;

@Getter
public class Vehicle {
  private VehicleBoard board;

  public Vehicle(VehicleBoard board) {
    this.board = board;
  }
}
