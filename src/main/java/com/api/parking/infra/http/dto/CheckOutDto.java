package com.api.parking.infra.http.dto;


import jakarta.validation.constraints.Null;

public record CheckOutDto (
  @Null
  String vehicleBoard
) {}
