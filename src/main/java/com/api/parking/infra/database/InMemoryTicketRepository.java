package com.api.parking.infra.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.api.parking.domain.Ticket;
import com.api.parking.domain.TicketRepository;
import com.api.parking.domain.TicketStatus;
import com.api.parking.domain.VehicleBoard;

@Repository
public class InMemoryTicketRepository implements TicketRepository {
  private List<Ticket> tickets = new ArrayList<>();

  @Override
  public List<Ticket> findActives() {
    return this.tickets
      .stream()
      .filter(ticket -> ticket.getStatus() == TicketStatus.ACTIVE)
      .toList();
  }

  @Override
  public Optional<Ticket> findByVehiceBoard(VehicleBoard vehicleBoard) {
    return this.tickets
      .stream()
      .filter(ticket -> ticket.getVehicleBoard().equals(vehicleBoard))
      .findFirst();
  } 

  @Override
  public List<Ticket> findHistory() {
    return this.tickets
      .stream()
      .filter(ticket -> ticket.getStatus() != TicketStatus.ACTIVE)
      .toList();
  }

  @Override
  public void save(Ticket ticket) {
    this.tickets.add(ticket);
  }


}
