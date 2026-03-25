package com.api.parking;

import static org.assertj.core.api.Assertions.assertThat;

  import org.junit.jupiter.api.DisplayName;
  import org.junit.jupiter.api.Test;

import com.api.parking.application.CheckOutRequest;
import com.api.parking.application.CheckOutUseCase;

import com.api.parking.domain.Spot;
import com.api.parking.domain.Ticket;
import com.api.parking.domain.VehicleBoard;

import com.api.parking.infra.InMemorySpotRepository;
import com.api.parking.infra.InMemoryTicketRepository;

public class CheckOutUseCaseTest {
  @Test
  @DisplayName("Should be able to checkout a vehicle from parking")
  void shouldBeAbleToCheckoutVehicleFromParking() {
    var ticketRepository = new InMemoryTicketRepository(); 
    var spotRepository = new InMemorySpotRepository();
    var checkoutUseCase = new CheckOutUseCase(ticketRepository, spotRepository);

    var spot = Spot.create(1);
    spotRepository.save(spot);

    var ticket = Ticket.create(new VehicleBoard("AA-12-12-BB"), spot.getId());
    ticketRepository.save(ticket);

    var checkOutRequest = new CheckOutRequest("AA-12-12-BB", ticket.getId());
    var response = checkoutUseCase.execute(checkOutRequest);

    assertThat(response.spotId()).isEqualTo(spot.getId());
  }
}
