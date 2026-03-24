package com.api.parking.infra.postgresql;

import com.api.parking.domain.Spot;
import com.api.parking.infra.jpa.SpotModel;

public class PostgreSQLSpotMapper {
  static Spot toDomain(SpotModel spotModel) {
    return Spot.restore(
      spotModel.getId(), 
      spotModel.getStatus()
    );
  }

  static SpotModel toJpaModel(Spot spot) {
    var spotModel = new SpotModel();
    spotModel.setId(spot.getId());
    spotModel.setStatus(spot.getStatus());
    return spotModel;
  }
}
