package com.api.parking.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.parking.domain.Spot;
import com.api.parking.domain.SpotRepository;

@Service
public class GetAvailablesSpotUseCase {
  private final SpotRepository spotRepository;

  public GetAvailablesSpotUseCase(SpotRepository spotRepository) {
    this.spotRepository = spotRepository;
  }

  public List<Spot> execute() {
    return this.spotRepository.findAvailablesSpot();
  }
}