package com.api.parking.domain.exceptions;

import org.springframework.http.HttpStatus;

public class NotAvailableSpotException extends DomainError {
  public NotAvailableSpotException() {
    super("Não há vagas disponíveis.", HttpStatus.CONFLICT);
  }
}
