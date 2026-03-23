package com.api.parking.infra.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.parking.domain.SpotStatus;

import com.api.parking.infra.jpa.JpaSpotRepository;
import com.api.parking.infra.jpa.SpotModel;

@Component
public class DataBaseSeeder implements CommandLineRunner {

    private final JpaSpotRepository jpaSpotRepository;

    public DataBaseSeeder(JpaSpotRepository jpaSpotRepository) {
        this.jpaSpotRepository = jpaSpotRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (jpaSpotRepository.count() == 0) {
            for (int i = 0; i < 10; i++) {
                SpotModel spot = new SpotModel();
                spot.setStatus(SpotStatus.AVAILABLE);
                jpaSpotRepository.save(spot);
            }
            System.out.println("10 vagas criadas!");
        }
    }
}
