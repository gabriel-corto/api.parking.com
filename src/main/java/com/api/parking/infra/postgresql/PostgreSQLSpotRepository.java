package com.api.parking.infra.postgresql;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Primary;

import com.api.parking.domain.Spot;
import com.api.parking.domain.SpotStatus;
import com.api.parking.domain.SpotRepository;

import com.api.parking.infra.jpa.JpaSpotRepository;

@Repository
@Primary
public class PostgreSQLSpotRepository implements SpotRepository {
  private final JpaSpotRepository jpaSpotRepository;

  public PostgreSQLSpotRepository(JpaSpotRepository jpaSpotRepository) {
    this.jpaSpotRepository = jpaSpotRepository;
  }

  @Override
  public List<Spot> findAll() {
    return this.jpaSpotRepository.findAll()
      .stream()
        .map(s -> PostgreSQLSpotMapper.toDomain(s)).toList();
  }

  @Override
  public Optional<Spot> findAvailableSpot() {
    return this.jpaSpotRepository.findAll()
      .stream()
        .filter(s -> s.getStatus() == SpotStatus.AVAILABLE)
          .findFirst()
            .map(s -> PostgreSQLSpotMapper.toDomain(s));
  }

  @Override
  public List<Spot> findAvailablesSpot() {
    return this.jpaSpotRepository.findAll()
      .stream()
        .filter(s -> s.getStatus() == SpotStatus.AVAILABLE)
          .map(s -> PostgreSQLSpotMapper.toDomain(s))
            .toList();
  }

  @Override
  public void save(Spot spot) {
    var spotModel = PostgreSQLSpotMapper.toJpaModel(spot);
    this.jpaSpotRepository.save(spotModel);
  }
}
