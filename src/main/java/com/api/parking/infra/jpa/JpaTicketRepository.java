package com.api.parking.infra.jpa;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTicketRepository extends JpaRepository<TicketModel, UUID> {  
  Optional<TicketModel> findFirstByVehicleBoard(String vehicleBoard);
}
