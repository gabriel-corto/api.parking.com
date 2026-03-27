package com.api.parking.infra.http;

import java.util.UUID;

public record CheckOutResponse(
  UUID ticketId, 
  String vehicleBoard, 
  Integer spotId, 
  Double totalParking, 
  long totalPassedHours
) {}
