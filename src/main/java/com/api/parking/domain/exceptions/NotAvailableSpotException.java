package com.api.parking.domain.exceptions;

public class NotAvailableSpotException extends DomainError {
  public NotAvailableSpotException() {
    super("Não há vagas disponíveis.");
  }
}
