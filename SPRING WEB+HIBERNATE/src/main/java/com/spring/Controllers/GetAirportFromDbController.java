package com.spring.Controllers;

import com.spring.Repository.Entities.Airport;
import com.spring.Repository.DbDemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/airports")
public class GetAirportFromDbController {
    @Autowired
    DbDemoRepository dbDemoRepository;

    @GetMapping(produces = "html/text")
    public String getAllFromDB(Model model) {
        List<Airport> airportList = dbDemoRepository.findAll();
        model.addAttribute("dbResultList", airportList); // .toString() Thymeleaf calls automatic?
        return "dbModelPage";
    }

    @GetMapping(value = "/getairport", produces = "html/text")
    @ResponseBody
    public String getAirportByCode(
            @RequestParam(name = "code") String airportCode) {
        return dbDemoRepository.getAirportByAirportCode(airportCode).toString();
    }

    @GetMapping(value = "/getairport/{airportCode}", produces = "html/text")
    @ResponseBody
    public String getAirportByCodeByPath(
            @PathVariable(value = "airportCode") String airportCode) {
        return dbDemoRepository.getAirportByAirportCode(airportCode).toString();
    }
}
