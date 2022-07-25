package com.spring;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping(value = "/")
public class CustomJsonController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.ALL_VALUE)
    @ResponseBody
    String receiveCustomJson(@RequestBody ClassWithDate classWithDate) {
        return classWithDate.toString();
    }
}


@Getter
@Setter
@ToString
class ClassWithDate {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    Date date;
}