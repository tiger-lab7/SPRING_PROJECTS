package com.spring.Repository;

import com.spring.Entities.Airport;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DbDemoRepository extends CrudRepository<Airport, String> {
    List<Airport> findAll();
    Airport getAirportByAirportCode(String airportCode);
}
