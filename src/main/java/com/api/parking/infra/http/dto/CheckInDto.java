package com.api.parking.infra.http.dto;

import jakarta.validation.constraints.NotBlank;

public record CheckInDto(
    @NotBlank(message = "Placa do veículo não pode estar vazia.") 
    String vehicleBoard
) {}