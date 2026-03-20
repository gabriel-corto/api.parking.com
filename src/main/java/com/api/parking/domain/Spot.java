package com.api.parking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spot {
  private Integer id;
  private SpotStatus status;

  public void occupy() {
    this.status = SpotStatus.OCCUPIED;
  }
}