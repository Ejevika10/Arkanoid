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
    public void serializeToTextFile(String filename, DisplayObject[] allObj,Settings settings,Players players) {
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
        settings.toString(filename);
        players.players[0].toString(filename);
    }
    public void deserializeFromTextFile(String filename, AllObjects allObj,Settings settings,Players players){
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
                    case "Settings" ->{
                        settings.fromString(reader.readLine());
                        break;
                    }
                    case "Player" ->{
                        players.players[0].fromString(reader.readLine());
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
    public void serializeToJsonFile(String filename, DisplayObject[] allObj,Settings settings,Players players) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        ObjectNode settingsNode = mapper.valueToTree(settings);
        root.set("settings", settingsNode);

        ObjectNode playersNode = mapper.valueToTree(players.players[0].stat);
        root.set("players", playersNode);

        ArrayNode objectsNode = root.putArray("objects");
        for (DisplayObject object : allObj) {
            ObjectNode objectNode = mapper.valueToTree(object);
            objectsNode.add(objectNode);
        }
        try {
            File file = new File(filename);
            mapper.writeValue(file, root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserializeFromJsonFile(String filename, AllObjects allObj,Settings settings,Players players) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(new File(filename));

            settings.fromJson(rootNode);

            players.fromJson(rootNode);

            allObj.fromJson(rootNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
