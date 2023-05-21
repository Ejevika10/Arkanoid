import com.fasterxml.jackson.databind.JsonNode;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Players {
    Player[] players;

    Players(){
        players = new Player[1];
        players[0] = new Player();
        Game.gameField.menuPanel.stat.setText(getFullStatistic());
    }
    public String getFullStatistic(){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for (Player player:players)
        {
            sb.append(player.getPlayerStatistic());
        }
        String res = sb.toString();
        return res;
    }

    public void fromJson(JsonNode rootNode){
        JsonNode playersNode = rootNode.get("players");
        players[0].stat.lives = (playersNode.get("lives").asInt());
        players[0].stat.score = (playersNode.get("score").asInt());
        players[0].stat.name = (playersNode.get("name").asText());
    }

}
