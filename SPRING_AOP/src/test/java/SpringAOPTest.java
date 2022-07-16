import com.spring.SomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(
        classes = {com.spring.SomeService.class, com.spring.Aspects.MyAspect.class})
@Configuration
public class SpringAOPTest {

    @Autowired
    SomeService someService;

    @Test
    public void testLogging() {
        someService.myMethod();
    }
}
