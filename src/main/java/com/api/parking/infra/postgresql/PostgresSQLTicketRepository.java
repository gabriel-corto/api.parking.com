package com.api.parking.infra.postgresql;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.api.parking.domain.Ticket;
import com.api.parking.domain.TicketRepository;
import com.api.parking.domain.TicketStatus;
import com.api.parking.domain.VehicleBoard;
import com.api.parking.infra.jpa.JpaTicketRepository;

@Repository
@Primary
public class PostgresSQLTicketRepository implements TicketRepository {
  private final JpaTicketRepository jpaTicketRepository;

  public PostgresSQLTicketRepository(JpaTicketRepository jpaTicketRepository) {
    this.jpaTicketRepository = jpaTicketRepository;
  }

  @Override
  public List<Ticket> findActives() {
    return this.jpaTicketRepository.findAll()
      .stream()
        .filter(t -> t.getStatus() == TicketStatus.ACTIVE)
            .map(t -> PostgreSQLTicketMapper.toDomain(t)) 
            .toList();
  }

 @Override
 public List<Ticket> findHistory() {
    return this.jpaTicketRepository.findAll()
      .stream()
        .map(t -> PostgreSQLTicketMapper.toDomain(t))
          .toList();
 }

  @Override
  public Optional<Ticket> findByVehiceBoard(VehicleBoard vehicleBoard) {
    return this.jpaTicketRepository.findFirstByVehicleBoard(vehicleBoard.getValue())
      .map(t -> PostgreSQLTicketMapper.toDomain(t));
  }

  @Override
  public void save(Ticket ticket) {
    var ticketModel = PostgreSQLTicketMapper.toJpaModel(ticket);
    this.jpaTicketRepository.save(ticketModel);
  }
}
