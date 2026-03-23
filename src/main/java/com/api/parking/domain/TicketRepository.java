package com.api.parking.domain;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
  List<Ticket> findActives();
  List<Ticket> findHistory();
  Optional<Ticket> findByVehiceBoard(VehicleBoard vehicleBoard);
  void save(Ticket ticket);
}
