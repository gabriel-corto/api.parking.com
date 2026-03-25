package com.api.parking.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spot {
  private Integer id;
  private SpotStatus status;

  public Spot(Integer id, SpotStatus status) {
    this.id = id;
    this.status = status;
  }

  public static Spot create(Integer id) {
    return new Spot(id, SpotStatus.AVAILABLE);
  }

  public static Spot restore(Integer id, SpotStatus status) {
    return new Spot(id, status);
  }

  public void occupy() {
    this.status = SpotStatus.OCCUPIED;
  }

  public void leave() {
    this.status = SpotStatus.AVAILABLE;
  }
}