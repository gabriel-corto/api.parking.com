package com.api.parking.infra.http;

import java.time.LocalDateTime;
import java.util.UUID;

import com.api.parking.domain.TicketStatus;

public record TicketResponse(
  UUID id,
  TicketStatus status,
  String vehicleBoard, 
  Integer spotId, 
  LocalDateTime entryTime 
) {}
