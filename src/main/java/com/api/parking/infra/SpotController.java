package com.api.parking.infra;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.parking.application.CheckInRequest;
import com.api.parking.application.CheckInUseCase;
import com.api.parking.domain.Ticket;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/parking")
public class SpotController {
  private final CheckInUseCase checkInUseCase;

  public SpotController(CheckInUseCase checkInUseCase) {
    this.checkInUseCase = checkInUseCase;
  }

  @PostMapping("/check-in")
  public ResponseEntity<Ticket> checkIn(@RequestBody CheckInDto body) {
    var request = new CheckInRequest(body.vehicleBoard());
    var ticket = this.checkInUseCase.execute(request);

    return ResponseEntity.ok(ticket);
  }
  
}
