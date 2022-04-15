package MainPackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args)  {
        var context = SpringApplication.run(Main.class, args);
        System.out.println(context.containsBean("MrBean"));

        Bean2 bean2 = context.getBeansOfType(Bean2.class).get("bean2");
        bean2.finder();
    }
}


