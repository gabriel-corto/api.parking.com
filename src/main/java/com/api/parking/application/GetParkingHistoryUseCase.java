package com.api.parking.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.parking.domain.Ticket;
import com.api.parking.domain.TicketRepository;

@Service
public class GetParkingHistoryUseCase {
  private final TicketRepository ticketRepository;

  public GetParkingHistoryUseCase(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public List<Ticket> execute() {
    return this.ticketRepository.findHistory();
  }
}
