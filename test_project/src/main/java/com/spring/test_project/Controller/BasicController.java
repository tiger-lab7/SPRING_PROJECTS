package com.spring.test_project.Controller;

import com.spring.test_project.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BasicController {
    @Autowired
    TicketService ticketService;

    /*@GetMapping(value = "/")
    String getIndexPage(@RequestParam(value = "id", required = false) String id,
                        @RequestParam(value = "name", required = false) String name,
                        Model model) {
        if (id != null)
            model.addAttribute("result", ticketService.getJsonTicketById(id));
        else if (name != null)
            model.addAttribute("result", ticketService.getStringTicketsByPassengerName(name));
        return "index";
    }*/

    /* @GetMapping(value = "/")
    String getIndexPageList(@RequestParam(value = "id") List<String> ids,
            Model model){
        List<String> resultList = new ArrayList<>();
        for (String id : ids)
            resultList.add(ticketService.getJsonTicketById(id));

        model.addAttribute("result", resultList);
        return  "index";
    } */

    @GetMapping(value = "/")
    String getIndexPageMap(@RequestParam Map<String, String> params,
                            Model model){
        List<String> resultList = new ArrayList<>();
        for (String param : params.keySet()) {
            if (param.equals("id"))
                resultList.add(ticketService.getJsonTicketById(params.get(param)));
            if (param.equals("name")) {
                resultList.addAll(ticketService.getStringTicketsByPassengerName(params.get(param)));
            }
        }
        model.addAttribute("result", resultList);
        return  "index";
    }

    @GetMapping(value = "/{id}")
    String getIndexPageByPath(@PathVariable("id") String id, Model model) {
        model.addAttribute("result", ticketService.getJsonTicketById(id));
        return "index";
    }
}
