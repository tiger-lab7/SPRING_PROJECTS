package com.example.SPRING_ANNOTATIONS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/servlet_analog")
public class ServletAnalogController {

    @GetMapping
    public void doGet(HttpServletRequest httpServletRequest,
                      HttpServletResponse httpServletResponse) throws IOException {
        PrintWriter printWriter = httpServletResponse.getWriter();
        printWriter.println("<!DOCTYPE html>");
        printWriter.println("<strong><center>HELLO FROM SERVLET ANALOG IN SPRING!</center></strong>");
        printWriter.println("<p>Request parameters " + httpServletRequest.getQueryString() + "</p>");
        Enumeration<String> headerNames =  httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements())
            printWriter.println("<p>"+httpServletRequest.getHeader(headerNames.nextElement())+"</p>");
    }


    @PostMapping
    public void doPost(HttpServletRequest httpServletRequest,
                       HttpServletResponse httpServletResponse) throws IOException {
        PrintWriter printWriter = httpServletResponse.getWriter();
        //String requestJson = httpServletRequest.getParameter("json");
        BufferedReader reader = httpServletRequest.getReader();
        String requestBody = reader.lines().collect(Collectors.joining());
        printWriter.println(requestBody);
        reader.close();
    }
}
