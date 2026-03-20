package com.api.parking.infra.jpa;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tickets")
public class TicketModel {
  @Id
  private UUID id;
  private Integer spotId;
  private String vehicleBoard;
  private LocalDateTime entryTime;
}
