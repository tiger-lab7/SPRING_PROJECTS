package com.springapplication;

import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@Controller
public class StopServerController {

    @RequestMapping(value = "/stop")
    @SneakyThrows
    public void stopServer(HttpServletResponse response) {
        response.setContentType("text/html");
        String htmlString = new BufferedReader(
                new FileReader("src/main/resources/static.html/stop_server.html"))
                .lines()
                .collect(Collectors.joining());

        PrintWriter printWriter = response.getWriter();
        printWriter.print(htmlString);
        printWriter.close();

        new ServerStop().start();
    }
}

class ServerStop extends Thread {
    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1000);
        System.exit(0);
    }
}
