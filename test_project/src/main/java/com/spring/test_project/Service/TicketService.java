package com.spring.test_project.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.test_project.Entities.Ticket;
import com.spring.test_project.Repository.TicketRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TicketService {
    @Autowired
    TicketRepository ticketRepository;

    @SneakyThrows
    public String getJsonTicketById(String id) {
        String result = "No result";
        Optional<Ticket> resultQuery = ticketRepository.findById(id);
        if (resultQuery.isPresent()) {
            Ticket ticket = resultQuery.get();

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writerFor(Ticket.class);
            result = objectWriter.writeValueAsString(ticket);
        }
        return result;
    }

    public List<String> getStringTicketsByPassengerName(String name) {
        List<Ticket> ticketList = ticketRepository.findAllByPassengerName(name);
        List<String> resultList = new ArrayList<>();
        for (Ticket t : ticketList)
            resultList.add(t.toString());
        return resultList;
    }

    private String jsonParser(String json) {
        //JsonNode jsonNode = new J
    }
}
