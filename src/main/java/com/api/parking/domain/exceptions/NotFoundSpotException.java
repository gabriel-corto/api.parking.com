package com.api.parking.domain.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundSpotException extends DomainError {
  public NotFoundSpotException() {
    super("Vaga não encontrada.", HttpStatus.NOT_FOUND);
  }
}
