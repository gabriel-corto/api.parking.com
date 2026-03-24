package com.api.parking.domain.exceptions;

public class TicketAlreadyClosedException extends DomainError {
  public TicketAlreadyClosedException() {
    super("O Veículo Já saiu do estacionamento!");
  }
}
