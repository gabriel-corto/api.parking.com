package com.api.parking.domain.exceptions;

public class NotFoundTicketException extends DomainError {
  public NotFoundTicketException() {
    super("Ticket não encontrado.");
  }
}
