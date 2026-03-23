package com.api.parking.infra.http;

import java.util.List;

import com.api.parking.domain.Spot;

import com.api.parking.application.CheckInRequest;
import com.api.parking.application.CheckInUseCase;
import com.api.parking.application.GetActivesVehicleUseCase;
import com.api.parking.application.GetAvailablesSpotUseCase;
import com.api.parking.application.GetParkingHistoryUseCase;
import com.api.parking.application.GetSpostsUseCase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/parking")
public class ParkingController {
  private final CheckInUseCase checkInUseCase;
  private final GetSpostsUseCase getSpostsUseCase;
  private final GetAvailablesSpotUseCase getAvailablesSpotUseCase;
  private final GetParkingHistoryUseCase getParkingHistoryUseCase;
  private final GetActivesVehicleUseCase getActivesVehiclesUseCase;

  public ParkingController
  (
    CheckInUseCase checkInUseCase, 
    GetSpostsUseCase getSpostsUseCase,
    GetAvailablesSpotUseCase getAvailablesSpotUseCase, 
    GetActivesVehicleUseCase getActivesVehicleUseCase,
    GetParkingHistoryUseCase getParkingHistoryUseCase
  ) {
    this.checkInUseCase = checkInUseCase;
    this.getSpostsUseCase = getSpostsUseCase;
    this.getAvailablesSpotUseCase = getAvailablesSpotUseCase;
    this.getActivesVehiclesUseCase = getActivesVehicleUseCase;
    this.getParkingHistoryUseCase = getParkingHistoryUseCase;
  }

  @GetMapping("/spots")
  public ResponseEntity<List<Spot>> getSpots() {
    var spots = this.getSpostsUseCase.execute();
    return ResponseEntity.ok(spots);
  }

  @GetMapping("/spots/available")
  public ResponseEntity<List<Spot>> getAvailables() {
    var spots = this.getAvailablesSpotUseCase.execute();
    return ResponseEntity.ok(spots);
  }

  @GetMapping("/active")
  public ResponseEntity<List<TicketResponse>> getActivesVehicles() {
    var tickets = this.getActivesVehiclesUseCase.execute();
    return ResponseEntity.ok(
      tickets.stream()
        .map(ticket -> new TicketResponse(
          ticket.getId(), 
          ticket.getStatus(), 
          ticket.getVehicleBoard().getValue(), 
          ticket.getSpotId(), 
          ticket.getEntryTime()
        )).toList());
  }
  
  @GetMapping("/history")
  public ResponseEntity<List<TicketResponse>> getParkingHistory() {
    var tickets = this.getParkingHistoryUseCase.execute();
    return ResponseEntity.ok(
      tickets.stream()
        .map(ticket -> new TicketResponse(
          ticket.getId(), 
          ticket.getStatus(), 
          ticket.getVehicleBoard().getValue(), 
          ticket.getSpotId(), 
          ticket.getEntryTime()
        )).toList());
  }  
  
  @PostMapping("/check-in")
  public ResponseEntity<TicketResponse> checkIn(@RequestBody CheckInDto body) {
    var request = new CheckInRequest(body.vehicleBoard());
    var ticket = this.checkInUseCase.execute(request);
    
    return ResponseEntity.ok(
      new TicketResponse(
        ticket.getId(), 
        ticket.getStatus(), 
        ticket.getVehicleBoard().getValue(), 
        ticket.getSpotId(), 
        ticket.getEntryTime()
      )   
    );
  }
  
}
