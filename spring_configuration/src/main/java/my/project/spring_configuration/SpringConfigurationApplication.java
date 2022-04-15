package my.project.spring_configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class SpringConfigurationApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringConfigurationApplication.class, args);

        ApplicationContext context =
                new ClassPathXmlApplicationContext("/applicationContext.xml");
        PetGreeter petGreeter = context.getBean(PetGreeter.class);

        petGreeter.greetAll();
    }
}
