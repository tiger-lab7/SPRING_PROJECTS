import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodesTree {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNodesTree = objectMapper.readTree(Data.inputJson);
        JsonNode catNode = jsonNodesTree.get("BARSIK");
        System.out.println(catNode.toString());
    }
}
