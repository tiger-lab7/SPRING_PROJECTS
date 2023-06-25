package com.spring.JERSEY_GLASSFISH;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;

@Controller  /* Если в классе контроллера - наследника не указан @Path,
то его начало подставляется из класса родителя */
public class SimpleController extends ParentController {

    @GET
    @Path("hello")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultClass getResult() {
        System.out.println("REQUEST");
        return new ResultClass("Hello", "Igor");
    }
}

@Data
@AllArgsConstructor
class ResultClass {
    private String greeting;
    private String name;
}