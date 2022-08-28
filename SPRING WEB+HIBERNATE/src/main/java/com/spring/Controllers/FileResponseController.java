package com.spring.Controllers;

/*
 * The FileResponseController class is demonstrated how to return binary zip file by GET request in Spring.
 * Class using Java.NIO for loading the file.
 * Spring creates new FileResponseController class for every request by @Scope("request") annotation.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@RestController
@Scope("request")
public class FileResponseController {
    private final Logger logger = LoggerFactory.getLogger(FileResponseController.class);

    @GetMapping(value = "/getfile", produces = "application/zip")
    public byte[] getZipFile() {
        return loadFile();
    }

    private byte[] loadFile() {
        try (RandomAccessFile file = new RandomAccessFile("src/main/resources/LEETCODE.zip", "r");
             FileChannel inChannel = file.getChannel()) {

            long fileSize = inChannel.size();

            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            inChannel.read(buffer);
            buffer.flip();
            return buffer.array();

        } catch (IOException ex) {
            logger.warn(String.valueOf(ex));
        }

        return new byte[]{};
    }
}
