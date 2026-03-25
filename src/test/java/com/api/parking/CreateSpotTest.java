package com.api.parking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.api.parking.domain.Spot;
import com.api.parking.domain.SpotStatus;

public class CreateSpotTest {
  @Test
  @DisplayName("Should be able to create a spot")

  void shouldBeAbleToCreateASpot() {
    var spot = new Spot(1, SpotStatus.AVAILABLE);    
    
    assertThat(spot).isNotNull();
    assertThat(spot.getId()).isEqualTo(1);
    assertThat(spot.getStatus()).isEqualTo(SpotStatus.AVAILABLE);
  }
}
