package com.api.parking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.api.parking.domain.Spot;
import com.api.parking.domain.SpotStatus;

public class CreateSpotTest {
  @Test
  @DisplayName("Should be able to create a spot")

  void shouldBeAbleToCreateASpot() {
    var spot = new Spot(Math.incrementExact(1), SpotStatus.AVAILABLE);
  }
}
