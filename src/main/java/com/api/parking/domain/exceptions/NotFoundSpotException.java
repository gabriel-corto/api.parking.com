package com.api.parking.domain.exceptions;

public class NotFoundSpotException extends DomainError {
  public NotFoundSpotException() {
    super("Vaga não encontrada.");
  }
}
