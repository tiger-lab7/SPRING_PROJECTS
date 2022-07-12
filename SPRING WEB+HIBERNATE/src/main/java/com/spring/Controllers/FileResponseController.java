package com.spring.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class FileResponseController {

    private byte[] loadFile() {
        byte[] result = null;
        try {
            result = new BufferedInputStream(
                    new FileInputStream("src/main/resources/LEETCODE.zip"))
                    .readAllBytes();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @GetMapping(value = "/getfile", produces = "application/zip")
    public byte[] getZipFile() {
        return loadFile();
    }
}
