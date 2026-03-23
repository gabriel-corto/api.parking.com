package com.api.parking.infra;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.api.parking.domain.Spot;
import com.api.parking.domain.SpotRepository;
import com.api.parking.domain.SpotStatus;

@Repository
public class InMemorySpotRepository implements SpotRepository {
  private List<Spot> spots = new ArrayList<>();

  @Override
  public Optional<Spot> findAvailableSpot() {
    return this.spots.stream().filter(spot -> spot.getStatus() == SpotStatus.AVAILABLE).findFirst();
  }

  @Override
  public List<Spot> findAvailablesSpot() {
    return this.spots.stream().toList();
  }

  @Override
  public List<Spot> findAll() {
    return this.spots.stream().toList();
  }

  @Override
  public void save(Spot spot) {
    this.spots.add(spot);
  }
}
