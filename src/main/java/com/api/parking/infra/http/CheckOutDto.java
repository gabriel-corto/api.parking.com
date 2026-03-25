package com.api.parking.infra.http;


import jakarta.validation.constraints.Null;

public record CheckOutDto (
  @Null
  String vehicleBoard
) {}
