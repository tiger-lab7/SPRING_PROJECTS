import com.spring.Main;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@ContextConfiguration(classes=Main.class) // Must be a basic app configuration class
public class ClassWithDateControllerTest {

    @BeforeAll
    static void appLauncher() {
        Main.main(new String[]{});
    }

    @Test
    @SneakyThrows
    void test1() {
        FileSystemResource fsr = new FileSystemResource("src/main/resources/customJson.json");
        String jsonString = new String(fsr.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(jsonString, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> result =
                restTemplate.exchange("http://localhost:8080", HttpMethod.POST, httpEntity, String.class);
        System.out.println(result.getBody());
    }
}
