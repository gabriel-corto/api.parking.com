package com.api.parking.infra.http;

import java.util.UUID;

import jakarta.validation.constraints.Null;

public record CheckOutDto (
  @Null
  String vehicleBoard,

  @Null
  UUID ticketId
) {}
