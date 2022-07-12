package Other;

import Collections.Country;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class Util {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static void writeJsonData(List<Country> countries) {
        objectMapper.writeValue(new File(Config.DATA_PATH), countries);
    }

    @SneakyThrows
    public static List<Country> readJsonData() {
        return objectMapper.readValue(new File(Config.DATA_PATH), new TypeReference<>() {
        });
    }
}
