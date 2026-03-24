package com.api.parking.domain;

import java.util.List;
import java.util.Optional;

public interface SpotRepository {
  List<Spot> findAvailablesSpot();
  List<Spot> findAll();
  Optional<Spot> findAvailableSpot();
  Optional<Spot> findById(Integer id);
  void save(Spot spot);
} 
