package bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;

@Component
public class Note {

    @Setter
    @Getter
    private String text;

    public Note() {}

    public Note(String text) {this.text = text;}

    @Override
    public String toString() {
        return "Note{"+"text='" + text + '\'' + '}';
    }
}
