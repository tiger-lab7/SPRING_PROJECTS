package com.springapplication;

import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

@Controller
@RequestMapping(value = "/resources")
public class ResourcesLoadController {

    @GetMapping(value = "/images")
    @SneakyThrows
    public void getImage(@RequestParam("name") String image_name, HttpServletResponse response){
        response.setContentType("image/jpeg");
        byte[] image =  new FileInputStream(
                "src/main/resources/static/images/" + image_name)
                .readAllBytes();
        ServletOutputStream servletOutputStream = response.getOutputStream();
        servletOutputStream.write(image);
        servletOutputStream.close();
    }
}
