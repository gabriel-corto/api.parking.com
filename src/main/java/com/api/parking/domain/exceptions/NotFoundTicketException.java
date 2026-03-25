package com.api.parking.domain.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundTicketException extends DomainError {
  public NotFoundTicketException() {
    super("Ticket não encontrado.", HttpStatus.NOT_FOUND);
  }
}
