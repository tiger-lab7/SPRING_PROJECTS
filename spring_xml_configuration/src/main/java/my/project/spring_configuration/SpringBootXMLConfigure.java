package my.project.spring_configuration;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;


// Test XML-beans configuration + Annotations
@SpringBootApplication
@Configuration
@ImportResource("classpath:applicationContext.xml")
public class SpringBootXMLConfigure {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootXMLConfigure.class, args);
    }
}

@Component
class Work {
    private PetGreeter petGreeter;
    @Autowired
    public void setPetGreeter(PetGreeter petGreeter) {
        this.petGreeter = petGreeter;
    }


    @PostConstruct
    public void start() {
        petGreeter.greetAll();
    }
}
