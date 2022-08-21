package spring.com;

import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.com.Repository.Cat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Controller
public class EM  {
    @PersistenceContext
    EntityManager entityManager;

    @GetMapping(value = "/")
    @ResponseBody
    @Transactional // Needed!
    public String runByRequest() {
        printDataFromDb();
        return "OK";
    }

    @Transactional // Needed!
    @SneakyThrows
    public void runByTimer() {
        printDataFromDb();
    }

    private void printDataFromDb() {
        TypedQuery<Cat> query = entityManager.createQuery("select c from Cat c", Cat.class);
        query.getResultStream().forEach(cat -> System.out.println(cat.getId() + " " + cat.getName()));
    }
}


