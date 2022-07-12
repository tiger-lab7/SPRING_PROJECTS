package com.spring.Controllers;

import com.spring.Entities.Airport;
import com.spring.Repository.DbDemoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/db")
public class GetDBContoller {
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
            @RequestParam("code") String airportCode) {
        return dbDemoRepository.getAirportByAirportCode(airportCode).toString();
    }
}
