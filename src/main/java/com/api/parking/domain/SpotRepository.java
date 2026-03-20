package com.api.parking.domain;

import java.util.Optional;

public interface SpotRepository {
  Optional<Spot> findAvailableSpot();
  void save(Spot spot);
} 
