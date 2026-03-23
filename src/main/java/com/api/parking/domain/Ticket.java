package com.api.parking.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
  private UUID id; 
  private Integer spotId;
  private LocalDateTime entryTime;
  private VehicleBoard vehicleBoard;
  private TicketStatus status;

  public Ticket
  (
    UUID id, 
    VehicleBoard vehicleBoard, 
    Integer spotId, 
    LocalDateTime entryTime,
    TicketStatus status
  ) {
    this.id = id;
    this.spotId = spotId;
    this.entryTime = entryTime;
    this.vehicleBoard = vehicleBoard;
    this.status = TicketStatus.ACTIVE;
  }

  public static Ticket create(VehicleBoard vehicleBoard, Integer spotId) {
    return new Ticket(UUID.randomUUID(), vehicleBoard, spotId, LocalDateTime.now(), TicketStatus.ACTIVE);
  }

  public static Ticket restore
  (
    UUID id, 
    VehicleBoard vehicleBoard, 
    Integer spotId, 
    LocalDateTime entryTime, 
    TicketStatus status
  ) {
    return new Ticket(id, vehicleBoard, spotId, entryTime, status);
  }
    
}
