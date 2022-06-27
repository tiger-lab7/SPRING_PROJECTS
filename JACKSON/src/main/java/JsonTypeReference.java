import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.util.Map;

public class JsonTypeReference {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectReader objectReader = objectMapper.readerFor(new TypeReference<Map<String, Cat>>() {});
        Map<String, Cat> catMap = objectReader.readValue(Data.inputJson);
        catMap.forEach((catName, catObj) -> System.out.println(catName + " " + catObj));
    }
}

