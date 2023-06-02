import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class Settings implements Serializable {
    public int volume;
    public int brightness;
    public int difficulty;
    public int size;

    public void toString(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename, true))) {
            writer.println(getClass().getName());
            writer.println(volume + "," + brightness + "," + difficulty+ "," + size);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fromString(String content) {
        String[] parts = content.split(",");
        volume=(Integer.parseInt(parts[0]));
        brightness=(Integer.parseInt(parts[1]));
        difficulty=(Integer.parseInt(parts[2]));
        size=(Integer.parseInt(parts[3]));
    }
    public void fromJson(JsonNode rootNode){
        JsonNode settingsNode = rootNode.get("settings");
        volume = (settingsNode.get("volume").asInt());
        brightness = (settingsNode.get("brightness").asInt());
        difficulty = (settingsNode.get("difficulty").asInt());
        size = (settingsNode.get("size").asInt());
    }

}
