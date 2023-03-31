package BeanInitialization;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Component
class MyClass {
    private MyClass() {}
    public MyClass getInstance() {
        return new MyClass();
    }
    public void sing() {
        System.out.println("MyClass init!");
    }
}

@Component
class Runner implements CommandLineRunner {

    private MyClass myClass;

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
    }

    @Override
    public void run(String... args) throws Exception {
        myClass.sing();
    }
}
