package com.api.parking.domain.exceptions;

public class NotFoundPlate extends DomainError {
  public NotFoundPlate() {
    super("Placa do veículo não encontrada");
  }
}