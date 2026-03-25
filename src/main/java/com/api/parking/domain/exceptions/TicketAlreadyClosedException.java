package com.api.parking.domain.exceptions;

import org.springframework.http.HttpStatus;

public class TicketAlreadyClosedException extends DomainError {
  public TicketAlreadyClosedException() {
    super("Este ticket já foi encerrado.", HttpStatus.CONFLICT);
  }
}
