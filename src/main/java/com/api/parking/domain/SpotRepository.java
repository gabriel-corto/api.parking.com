package com.api.parking.domain;

import java.util.List;
import java.util.Optional;

public interface SpotRepository {
  Optional<Spot> findAvailableSpot();
  List<Spot> findAvailablesSpot();
  List<Spot> findAll();
  void save(Spot spot);
} 
