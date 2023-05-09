import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Serialization {
    public void serializeToTextFile(String filename, DisplayObject[] allObj) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write("");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (DisplayObject obj: allObj)
        {
            obj.toString(filename);
        }
    }
    public void deserializeFromTextFile(String filename, AllObjects allObj){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int i = 0;
            String className = reader.readLine();
            while(className != null)
            {
                //String className = reader.readLine();
                switch (className) {
                    case "Block" -> {
                        ((Block) Game.gameField.allObj.allObj[i]).fromString(reader.readLine());
                        i++;
                        break;
                    }
                    case "Ball" -> {
                        ((Ball) Game.gameField.allObj.allObj[i]).fromString(reader.readLine());
                        i++;
                        break;
                    }
                    case "Platform" -> {
                        ((Platform) Game.gameField.allObj.allObj[i]).fromString(reader.readLine());
                        allObj.activePlatform = (Platform) Game.gameField.allObj.allObj[i];
                        i++;
                        break;
                    }
                    default -> {
                    }
                }
                className = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void serializeToJsonFile(String filename, DisplayObject[] allObj) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        ArrayNode objectsNode = root.putArray("objects");
        for (DisplayObject object : allObj) {
            ObjectNode objectNode = mapper.valueToTree(object);
            //objectNode.put("type", object.getClass().getName());
            objectsNode.add(objectNode);
        }

        try {
            File file = new File(filename);
            mapper.writeValue(file, root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserializeFromJsonFile(String filename, AllObjects allObj) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            int i = 0;
            JsonNode rootNode = mapper.readTree(new File(filename));
            JsonNode objectsNode = rootNode.get("objects");
            for (JsonNode objectNode : objectsNode) {
                int classType = objectNode.get("type").asInt();
                switch (classType) {
                    case 2 -> {
                        Game.gameField.allObj.allObj[i] =  mapper.readValue(objectNode.toString(), Block.class);
                        i++;
                        break;
                    }
                    case 1 -> {
                        Game.gameField.allObj.allObj[i] =  mapper.readValue(objectNode.toString(), Ball.class);
                        i++;
                        break;
                    }
                    case 3 -> {
                        Game.gameField.allObj.allObj[i] =  mapper.readValue(objectNode.toString(), Platform.class);
                        allObj.activePlatform = (Platform) Game.gameField.allObj.allObj[i];
                        i++;
                        break;
                    }
                    default -> {
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
