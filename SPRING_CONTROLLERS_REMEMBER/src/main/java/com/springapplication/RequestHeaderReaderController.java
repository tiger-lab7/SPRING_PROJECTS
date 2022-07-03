package com.springapplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Controller
public class RequestHeaderReaderController {

    @RequestMapping(value = "/", method = RequestMethod.GET,
            produces = "text/html; charset=UTF-8")
    @ResponseBody()
    public String readRequestHeaders(HttpServletRequest request) {
        StringBuilder result = new StringBuilder("<!DOCTYPE html>");

        Enumeration<String> headers = request.getHeaderNames();

        while(headers.hasMoreElements()) {
            String headerName = headers.nextElement();
            result.append("<p>" + headerName + ": " +
                request.getHeader(headerName) + "</p>");
        }

        return result.toString();
    }
}
