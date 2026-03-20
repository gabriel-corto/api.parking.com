package com.api.parking.infra.database;

import org.springframework.stereotype.Repository;

import com.api.parking.domain.Ticket;
import com.api.parking.domain.TicketRepository;
import com.api.parking.infra.jpa.JpaTicketRepository;

@Repository
public class PostgresSQLTicketRepository implements TicketRepository {
  private final JpaTicketRepository jpaTicketRepository;

  public PostgresSQLTicketRepository(JpaTicketRepository jpaTicketRepository) {
    this.jpaTicketRepository = jpaTicketRepository;
  }

  @Override
  public void save(Ticket ticket) {
    var ticketModel = PostgreSQLTicketMapper.toJpaModel(ticket);
    this.jpaTicketRepository.save(ticketModel);
  }
}
