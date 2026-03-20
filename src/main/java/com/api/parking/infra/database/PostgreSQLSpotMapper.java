package com.api.parking.infra.database;

import com.api.parking.domain.Spot;
import com.api.parking.infra.jpa.SpotModel;

public class PostgreSQLSpotMapper {
  static Spot toDomain(SpotModel spotModel) {
    var spot = new Spot();
    spot.setId(spotModel.getId());
    spot.setStatus(spotModel.getStatus());
    return spot;
  }

  static SpotModel toJpaModel(Spot spot) {
    var spotModel = new SpotModel();
    spotModel.setId(spot.getId());
    spotModel.setStatus(spot.getStatus());
    return spotModel;
  }
}
