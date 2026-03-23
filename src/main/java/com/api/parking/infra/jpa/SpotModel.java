package com.api.parking.infra.jpa;

import com.api.parking.domain.SpotStatus;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import lombok.Getter;
import lombok.Setter;
  
@Getter
@Setter
@Entity(name = "spots")
public class SpotModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Enumerated(EnumType.STRING)
  private SpotStatus status;

}
