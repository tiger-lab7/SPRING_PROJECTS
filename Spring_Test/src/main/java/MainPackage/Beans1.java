package MainPackage;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component("MrBean")
public class Beans1 {

    @PostConstruct
    void message() {
        System.out.println("Бин создан!");
    }

    @PreDestroy
    void message2() { System.out.println("Бин уничтожен!");}

}

@Component
class Bean2 {

    void finder() {
        String text = "Теперь давайте воспользуемся третьей замечательной особенностью Spring Boot — это встроенный сервер";
        System.out.println(text.indexOf("третьей"));
        System.out.println(text.lastIndexOf("третьей"));
        System.out.println(text.matches(".+ава.+"));
    }

}
