package com.api.parking.application;

import org.springframework.stereotype.Service;

import com.api.parking.domain.Ticket;
import com.api.parking.domain.TicketRepository;
import com.api.parking.domain.Vehicle;
import com.api.parking.domain.VehicleBoard;
import com.api.parking.domain.exceptions.NotAvailableSpotException;
import com.api.parking.domain.exceptions.VehicleAlreadyParkedException;
import com.api.parking.domain.SpotRepository;

@Service
public class CheckInUseCase {
  private final SpotRepository spotRepository;
  private final TicketRepository ticketRepository;

  public CheckInUseCase(SpotRepository spotRepository, TicketRepository ticketRepository) {
    this.spotRepository = spotRepository;
    this.ticketRepository = ticketRepository;
  }

  public Ticket execute(CheckInRequest request) {
    var vehicle = new Vehicle(new VehicleBoard(request.vehicleBoard()));
    var availableSpot = this.spotRepository.findAvailableSpot();

    var vehicleAlreadyParked = ticketRepository.findByVehiceBoard(vehicle.getBoard());

    if(vehicleAlreadyParked.isPresent()) {
      throw new VehicleAlreadyParkedException("O Veículo " + vehicle.getBoard().getValue() + " Já Está Estacionado!");
    }

    if(availableSpot.isEmpty()) {
     throw new NotAvailableSpotException();
    }

    availableSpot.get().occupy();
    var ticket = Ticket.create(vehicle.getBoard(), availableSpot.get().getId());
    
    spotRepository.save(availableSpot.get());
    ticketRepository.save(ticket);

    return ticket;
  }
}
