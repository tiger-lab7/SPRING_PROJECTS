package com.example.SPRING_ANNOTATIONS;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ReceiveJsonController {

    @PostMapping(value = "/send_json", produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public void postResponse(Model model, @RequestBody User user) {

        System.out.println(user.getId() + " " + user.getName());
    }
}


class User {
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;
}
