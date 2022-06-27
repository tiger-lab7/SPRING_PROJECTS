import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.util.Map;

public class JsonCustomDeserializerTest {

    public static void main(String[] args) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        SimpleModule module = new SimpleModule("CustomCatDeserializer",
                new Version(1, 0, 0, null, null, null));
        module.addDeserializer(Cat.class, new JsonCustomDeserializer());
        objectMapper.registerModule(module);

        ObjectReader objectReader = objectMapper.readerFor(new TypeReference<Map<String, Cat>>() {});

        Map<String, Cat> catMap = objectReader.readValue(Data.inputJson);

        catMap.forEach((catName, catObj) -> System.out.println(catName + " " + catObj));
    }
}


class JsonCustomDeserializer extends StdDeserializer<Cat> {

    public JsonCustomDeserializer() {
        this(null);
    }

    public JsonCustomDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Cat deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {

        Cat cat = new Cat();
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode catNode = objectCodec.readTree(jsonParser);

        JsonNode nameNode = catNode.get("name");
        String name = nameNode.toString();
        cat.setName(name + " very clever cat");

        JsonNode ageNode = catNode.get("age");
        int age = ageNode.intValue();
        cat.setAge(age);

        return cat;
    }
}
