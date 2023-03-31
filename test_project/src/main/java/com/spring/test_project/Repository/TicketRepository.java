package com.spring.test_project.Repository;

import com.spring.test_project.Entities.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, String> {
    List<Ticket> findAllByPassengerName(String name);
}
