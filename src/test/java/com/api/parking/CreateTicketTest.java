package com.api.parking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.api.parking.domain.Ticket;
import com.api.parking.domain.VehicleBoard;
import com.api.parking.domain.exceptions.InvalidVehicleBoardException;

public class CreateTicketTest {
  @Test
  @DisplayName("Should be able to create a parking ticket")
  void shouldBeAbleToCreateTicket() {
    var ticket = Ticket.create(new VehicleBoard("AA-12-12-BB"), 2);

    assertThat(ticket).isNotNull();
    assertThat(ticket.getVehicleBoard().getValue()).isEqualTo("AA-12-12-BB");
    assertThat(ticket.getSpotId()).isEqualTo(2);
  }

  @Test
  @DisplayName("Should not be able to create a parking ticket with invalid vehicle board")
  void shouldNotBeAbleCreateATicketWithInvalidVehicleBoard() {
    var invalidBoard = "AA-AA-AA-AA";     
        
    assertThatThrownBy(() -> {  
      Ticket.create(new VehicleBoard(invalidBoard), 2);
    }).isInstanceOf(InvalidVehicleBoardException.class);
  }
}
