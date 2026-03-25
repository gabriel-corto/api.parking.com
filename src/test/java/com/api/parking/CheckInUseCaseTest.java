package com.api.parking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.api.parking.application.CheckInRequest;
import com.api.parking.application.CheckInUseCase;
import com.api.parking.domain.Spot;
import com.api.parking.domain.TicketStatus;
import com.api.parking.infra.InMemorySpotRepository;
import com.api.parking.infra.InMemoryTicketRepository;

public class CheckInUseCaseTest {
  @Test
  @DisplayName("Should be able to check-in a vehicle to parking")
  void shouldBeAbleToCheckInAVehicleToParking() {
    var ticketRepository = new InMemoryTicketRepository();
    var spotRepository = new InMemorySpotRepository();

    var spot = Spot.create(1);
    spotRepository.save(spot);

    var checkInUseCase = new CheckInUseCase(spotRepository, ticketRepository);
    var request = new CheckInRequest("AA-12-12-BB");
    
    var ticket = checkInUseCase.execute(request);

    assertThat(ticket).isNotNull();
    assertThat(ticket.getSpotId()).isEqualTo(1);
    assertThat(ticket.getVehicleBoard().getValue()).isEqualTo("AA-12-12-BB");
    assertThat(ticket.getStatus()).isEqualTo(TicketStatus.ACTIVE);

  }
}
