package com.api.parking.domain;

import java.util.UUID;

public record CheckOutResponse(
  UUID ticketId, 
  String vehicleBoard, 
  Integer spotId, 
  Double totalParking, 
  long totalPassedHours
) {}
