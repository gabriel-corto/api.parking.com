package com.api.parking.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaSpotRepository extends JpaRepository<SpotModel, Integer> {

  
}
