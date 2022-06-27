import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class Data {
    private static final String PATH = "src/main/resources/input.json";
    public static String inputJson;
    static {
        try {
            inputJson = new BufferedReader(
                    new FileReader(PATH))
                    .lines()
                    .collect(Collectors.joining());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
