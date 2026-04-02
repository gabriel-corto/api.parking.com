package com.api.parking.infra.http.controllers;

import java.util.List;

import com.api.parking.domain.Spot;
import com.api.parking.infra.http.CheckInResponse;
import com.api.parking.infra.http.CheckOutResponse;
import com.api.parking.infra.http.dto.CheckInDto;
import com.api.parking.infra.http.dto.CheckOutDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.api.parking.application.CheckInRequest;
import com.api.parking.application.CheckInUseCase;
import com.api.parking.application.CheckOutRequest;
import com.api.parking.application.CheckOutUseCase;
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

@RestController
@RequestMapping("/parking")
@Tag(name = "Parking")
public class ParkingController {
  private final CheckInUseCase checkInUseCase;
  private final CheckOutUseCase checkoutUseCase;
  private final GetSpostsUseCase getSpostsUseCase;

  private final GetAvailablesSpotUseCase getAvailablesSpotUseCase;
  private final GetParkingHistoryUseCase getParkingHistoryUseCase;
  private final GetActivesVehicleUseCase getActivesVehiclesUseCase;

  public ParkingController
  (
    CheckInUseCase checkInUseCase, 
    CheckOutUseCase checkoutUseCase,
    GetSpostsUseCase getSpostsUseCase,
    
    GetAvailablesSpotUseCase getAvailablesSpotUseCase, 
    GetActivesVehicleUseCase getActivesVehicleUseCase,
    GetParkingHistoryUseCase getParkingHistoryUseCase
  ) {
    this.checkInUseCase = checkInUseCase;
    this.checkoutUseCase = checkoutUseCase;
    this.getSpostsUseCase = getSpostsUseCase;

    this.getAvailablesSpotUseCase = getAvailablesSpotUseCase;
    this.getActivesVehiclesUseCase = getActivesVehicleUseCase;
    this.getParkingHistoryUseCase = getParkingHistoryUseCase;
  }

  @Operation(
    summary = "Lista todas as vagas do estacionamento", 
    description =  "Retorna uma lista com todas as vagas do estacionamento"
  )
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Lista de vagas"),
  })
  @GetMapping("/spots")
  public ResponseEntity<List<Spot>> getSpots() {
    var spots = this.getSpostsUseCase.execute();
    return ResponseEntity.ok(spots);
  }

  @Operation(
    summary = "Lista as vagas disponíveis do estacionamento", 
    description =  "Retorna uma lista com as vagas disponíveis do estacionamento"
  )
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Lista de vagas disponíveis"),
  })
  @GetMapping("/spots/available")
  public ResponseEntity<List<Spot>> getAvailables() {
    var spots = this.getAvailablesSpotUseCase.execute();
    return ResponseEntity.ok(spots);
  }

  @Operation(
    summary = "Lista os veículos ativos no estacionamento", 
    description =  "Retorna uma lista com os veículos ativos no estacionamento"
  )
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Lista de veículos ativos"),
  })
  @GetMapping("/active")
  public ResponseEntity<List<CheckInResponse>> getActivesVehicles() {
    var tickets = this.getActivesVehiclesUseCase.execute();
    return ResponseEntity.ok(
      tickets.stream()
        .map(ticket -> new CheckInResponse(
          ticket.getId(), 
          ticket.getStatus(), 
          ticket.getVehicleBoard().getValue(), 
          ticket.getSpotId(), 
          ticket.getEntryTime()
        )).toList());
  }
  
  @Operation(
    summary = "Lista o histórico de veículos que já passaram pelo estacionamento", 
    description =  "Retorna uma lista com o histórico de veículos que já passaram pelo estacionamento"
  )
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Lista de veículos ativos"),
  })
  @GetMapping("/history")
  public ResponseEntity<List<CheckInResponse>> getParkingHistory() {
    var tickets = this.getParkingHistoryUseCase.execute();
    return ResponseEntity.ok(
      tickets.stream()
        .map(ticket -> new CheckInResponse(
          ticket.getId(), 
          ticket.getStatus(), 
          ticket.getVehicleBoard().getValue(), 
          ticket.getSpotId(), 
          ticket.getEntryTime()
        )).toList());
  }  
  
  @Operation(
    summary = "Realiza o check-in de um veículo no estacionamento", 
    description =  "Realiza o check-in de um veículo no estacionamento"
  )
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Check-in realizado com sucesso"),
  })
  @PostMapping("/check-in")
  public ResponseEntity<CheckInResponse> checkIn(@RequestBody CheckInDto body) {
    var request = new CheckInRequest(body.vehicleBoard());
    var ticket = this.checkInUseCase.execute(request);

    
    return ResponseEntity.ok(
      new CheckInResponse(
        ticket.getId(), 
        ticket.getStatus(), 
        ticket.getVehicleBoard().getValue(), 
        ticket.getSpotId(), 
        ticket.getEntryTime()
      )   
    );
  }

  @Operation(
    summary = "Realiza o check-out de um veículo no estacionamento", 
    description =  "Realiza o check-out de um veículo no estacionamento"
  )
  @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Check-out realizado com sucesso"),
  })
  @PostMapping("/check-out")
  public ResponseEntity<CheckOutResponse> checkout(@RequestBody CheckOutDto body) {
    var request = new CheckOutRequest(body.vehicleBoard());
    var response = this.checkoutUseCase.execute(request);
    return ResponseEntity.ok(response);
  }
}
