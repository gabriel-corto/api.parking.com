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

  public Ticket
  (
    UUID id, 
    VehicleBoard vehicleBoard, 
    Integer spotId, 
    LocalDateTime entryTime
  ) {
    this.id = id;
    this.spotId = spotId;
    this.entryTime = entryTime;
    this.vehicleBoard = vehicleBoard;
  }

  public static Ticket create(VehicleBoard vehicleBoard, Integer spotId) {
    return new Ticket(UUID.randomUUID(), vehicleBoard, spotId, LocalDateTime.now());
  }

  public static Ticket restore
  (
    UUID id, 
    VehicleBoard vehicleBoard, 
    Integer spotId, 
    LocalDateTime entryTime
  ) {
    return new Ticket(id, vehicleBoard, spotId, entryTime);
  }
    
}
