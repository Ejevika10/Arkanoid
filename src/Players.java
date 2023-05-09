public class Players {
    Player[] players;

    Players(){
        players = new Player[1];
        players[0] = new Player();
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

}
