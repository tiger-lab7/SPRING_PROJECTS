package com.example.SPRING_ANNOTATIONS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping(value = "/write_to_output_stream")
public class WriteToOutputStreamController {

    @GetMapping
    @ResponseBody
    public void getReport(OutputStream outputStream) throws IOException {
        outputStream.write("HELLO FROM OUTPUT STREAM".getBytes(StandardCharsets.UTF_8));
    }
}
