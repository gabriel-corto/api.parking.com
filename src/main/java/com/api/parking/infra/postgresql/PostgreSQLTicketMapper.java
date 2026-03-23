package com.api.parking.infra.postgresql;


import com.api.parking.domain.Ticket;
import com.api.parking.domain.VehicleBoard;

import com.api.parking.infra.jpa.TicketModel;

public class PostgreSQLTicketMapper {
  static Ticket toDomain(TicketModel ticketModel) {
    return Ticket.restore(
      ticketModel.getId(),
      new VehicleBoard(ticketModel.getVehicleBoard()),
      ticketModel.getSpotId(),
      ticketModel.getEntryTime(),
      ticketModel.getStatus()
    );
  }

  static TicketModel toJpaModel(Ticket ticket) {
    var ticketModel = new TicketModel();

    ticketModel.setId(ticket.getId());
    ticketModel.setVehicleBoard(ticket.getVehicleBoard().getValue());
    ticketModel.setSpotId(ticket.getSpotId());
    ticketModel.setEntryTime(ticket.getEntryTime());
    ticketModel.setStatus(ticket.getStatus());

    return ticketModel;
  }
}
