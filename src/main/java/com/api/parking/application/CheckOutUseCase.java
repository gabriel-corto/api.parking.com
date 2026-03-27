package com.api.parking.application;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.api.parking.domain.Invoice;
import com.api.parking.domain.SpotRepository;
import com.api.parking.domain.TicketRepository;

import com.api.parking.domain.TicketStatus;
import com.api.parking.domain.VehicleBoard;

import com.api.parking.domain.exceptions.NotFoundSpotException;
import com.api.parking.domain.exceptions.NotFoundTicketException;
import com.api.parking.domain.exceptions.TicketAlreadyClosedException;
import com.api.parking.infra.http.CheckOutResponse;

@Service
public class CheckOutUseCase {
  private final TicketRepository ticketRepository;
  private final SpotRepository spotRepository;

  public CheckOutUseCase(TicketRepository ticketRepository, SpotRepository spotRepository) {
    this.ticketRepository = ticketRepository;
    this.spotRepository = spotRepository;
  }

  public CheckOutResponse execute(CheckOutRequest checkoutRequest) {
    var board = new VehicleBoard(checkoutRequest.vehicleBoard());
    var ticket = this.ticketRepository.findByVehiceBoard(board);

    if(ticket.isEmpty()) {
      throw new NotFoundTicketException();
    }

    if(ticket.get().getStatus() == TicketStatus.CLOSED) {
      throw new TicketAlreadyClosedException();
    }

    ticket.get().close();

    var spotId = ticket.get().getSpotId();
    var spot = spotRepository.findById(spotId);

    if(spot.isEmpty()) {
      throw new NotFoundSpotException();
    }
    spot.get().leave();
    
    spotRepository.save(spot.get());
    ticketRepository.save(ticket.get());

    var checkInTime = ticket.get().getEntryTime();
    var checkOutTime = LocalDateTime.now();

    Duration totalPassedTimes = Duration.between(checkInTime, checkOutTime);
    long totalPassedHours = totalPassedTimes.toHours();

    var totalParking = Invoice.issueParkingPrice(totalPassedHours);

    return new CheckOutResponse(
      ticket.get().getId(), 
      board.getValue(), 
      spotId, 
      totalParking, 
      totalPassedHours
    );
  }
}
 