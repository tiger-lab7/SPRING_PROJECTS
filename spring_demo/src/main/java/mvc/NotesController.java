package mvc;

import bean.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NotesController {

   // @Autowired
   // private Note morningNote;

    @GetMapping(value="/morningnote", produces="application/json")
    public String getMorningNote(){
        return "{'HELLO WORLD':'0'}";
        //return new Note("GOOD MORNING!");
    }

    @GetMapping(value="/morningnote1")
    public void alarm() {
        System.out.println("Пришел GET запрос!");
    }
}
